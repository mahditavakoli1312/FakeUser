package com.example.createuser.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.networkUtils.ResultWrapper
import com.example.core.ui.NetworkState
import com.example.createuser.data.datasource.remote.model.ResultResponse
import com.example.createuser.data.repository.FakeUserRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonDetailsViewModel @Inject constructor(
    private val fakeUserRepository: FakeUserRepository
) : ViewModel() {

    private val _userDetails =
        MutableStateFlow<ResultResponse>(ResultResponse())
    val userDetails = _userDetails.asStateFlow()

    private val _loadState = MutableSharedFlow<NetworkState>()
    val loadState = _loadState.asSharedFlow()

    val loading = _loadState.map { networkState ->
        when (networkState) {
            NetworkState.SUCCESS -> false
            NetworkState.INITIAL_STATE -> true
            NetworkState.APP_ERROR -> false
            NetworkState.SERVER_ERROR -> false
            NetworkState.NETWORK_ERROR -> false
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        true
    )

    init {
        fetchUser()
    }

    fun fetchUser() {
        viewModelScope.launch {
            when (val response = fakeUserRepository.createFakeUser()) {
                is ResultWrapper.ApplicationError -> {
                    _loadState.tryEmit(NetworkState.APP_ERROR)
                }
                is ResultWrapper.Failure -> _loadState.tryEmit(NetworkState.NETWORK_ERROR)
                is ResultWrapper.Success -> {
                    _userDetails.emit(response.data.results.first())
                }
            }
        }
    }

    fun generateAddress(): String {
        var address: String = ""
        _userDetails.value.apply {
            address += location?.country + ", "
            address += "city : " + location?.city + ", "
            address += "state : " + location?.state + ", "
            address += "street : " + location?.street?.name + " " + location?.street?.number + ", "
            address += "postcode : " + location?.postcode + ", "
            address += "phone : $phone"
        }
        return address
    }
}