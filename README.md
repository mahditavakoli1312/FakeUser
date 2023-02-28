# FakeUser
لینک پروژه ماژولار آموزشی : 

https://github.com/mahditavakoli1312/FakeUser.git


روند آموزش ماژولار در این پروژه جلو رفتم.

***کلیات پروژه***
- یک اپلیکیشن ماژولار برای دریافت اطلاعات جعلی شخصیت هست.(برای دور زدن سایت های خارجی که اطلاعات فیک می خوان)
- شامل 3 ماژول هست : 1- app :وظیفه integration برنامه را دارد و تمام ماژول ها در این ماژول ، implement می شوند. 2- core : شامل util ها و چیز های مشترک بین ماژول هاست. (نکته : خود core به چیزی وابسته نیست اما همه ماژول ها می توانند بسته به نیازشون به core وابسته باشند.) 3- createUser : فیچر ای که کاربر با آن تعامل مستقیم دارد در این برنامه ، همین فیچر هست . و برای ارتباط با app (در بخش های dagger  و database ) باید از dependency inversion استفاده کرد.

**در این پروژه :**
- از api رایگان برای دریافت اطلاعات فیک استفاده شده.
- ماژولارسازی از روش feature_based استفاده شده.
- از dependency inversion  برای dagger و RoomDataBase استفاده شده است.

****نحوه dependency inversion****

**برای Dagger :**

1. ابتدا اینترفیس PersonDetailsInjector را در ماژول فیچر پیاده سازی می کنیم.

`interface PersonDetailsInjector {
    fun inject(fragment: PersonDetailsFragment)
}`


2. سپس component آن فیچر که در ماژول app  ایجاد شده است باید PersonDetailsInjector  را implement کند.

`interface CreateUserComponent : PersonDetailsInjector {
    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            appDataBaseComponent: AppDataBaseComponent
        ): CreateUserComponent
    }
}`


3. سپس Application برنامه در اینجا (FakeUserApplication) باید PersonDetailsInjector  را implement کند.

`class FakeUserApplication : Application(), PersonDetailsInjector `


4. در مرحله بعد FakeUserApplication باید توابع PersonDetailsInjector  را override کند. 

`  override fun inject(fragment: PersonDetailsFragment) {
        createUserComponent.inject(fragment)
    }`


5. در مرحله اخر در متد onAttach فرگمنت مورد نظر (PersonDetailsFragment) عمل inject  را انجام می دهیم.

` override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as PersonDetailsInjector)
            .inject(this)
    }`

**برای DataBase** :
***اصلا چرا داریم از dependency inversion برای Database استفاده می کنیم ؟***

1 - دیتابیس برنامه در ماژول اپ ساخته می شود.


`   @Database(
       entities = [PersonEntity::class], version = 1
    )
  abstract class AppDataBase : RoomDatabase()`


2-در این برنامه entity ها -اگر روش هیبرید باشه خود entit هم در ماژول model ساخته میشه- و DAO  در ماژول فیچر createUser ساخته می شود.

3- برای ساختن AppDataBase نیاز هست که دسترسی به  DAO  ها داسته باشیم.

راه حل بر اساس شرح نیاز های 1و2و3 :

یک اینترفیس که شامل DAO  های آن ماژول هست در ماژول فیچر پیاده سازی می کنیم :

` interface PersonDataBase {
    fun personDao(): PersonDao
  }`


و این اینترفیس در ماژول اپ ایمپلمنت می شود.

`
   @Database(
       entities = [PersonEntity::class], version = 1
   )

   abstract class AppDataBase : RoomDatabase(), PersonDataBase
`
