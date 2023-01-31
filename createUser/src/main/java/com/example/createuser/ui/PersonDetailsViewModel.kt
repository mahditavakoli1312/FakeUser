package com.example.createuser.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.createuser.data.datasource.remote.model.ResultResponse
import com.example.createuser.data.repository.FakeUserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonDetailsViewModel @Inject constructor(
    private val fakeUserRepository: FakeUserRepository
) : ViewModel() {

    private val _userDetails =
        MutableStateFlow<ResultResponse>(ResultResponse())
    val userDetails = _userDetails.asStateFlow()

    init {
        fetchUser()
    }

    fun fetchUser() {
        viewModelScope.launch {
            val response = fakeUserRepository.createFakeUser()
            _userDetails.emit(response.results.first())
            Log.d("mahdi", "viewmodel:  ${response.results}")
            Log.d("mahdi", "value of state:${_userDetails.value} ")
        }
    }
}