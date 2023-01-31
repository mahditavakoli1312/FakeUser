package com.example.modularzation.di.module

import com.example.core.data.URLs
import com.example.modularzation.di.scope.NetworkScope
import com.example.core.networkUtils.HeaderInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class NetworkModule {

    companion object {

        @NetworkScope
        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gson: Gson
        ): Retrofit =
            Retrofit.Builder()
                .baseUrl(URLs.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        @Provides
        @NetworkScope
        fun provideGson(): Gson {
            return GsonBuilder().serializeNulls().create()
        }

        @Provides
        @NetworkScope
        fun provideAuthInterceptorOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor,
            headerInterceptor: HeaderInterceptor
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }

        @Provides
        @NetworkScope
        fun provideHeaderInterceptor(): HeaderInterceptor {
            return HeaderInterceptor.getInstance()
        }

        @Provides
        @NetworkScope
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }
    }
}