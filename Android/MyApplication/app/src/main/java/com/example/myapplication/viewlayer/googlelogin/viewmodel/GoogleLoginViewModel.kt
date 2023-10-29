package com.example.myapplication.viewlayer.googlelogin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.datalayer.api.network.ApiResponse
import com.example.myapplication.datalayer.api.network.handleApiRequest
import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginResponse
import com.example.myapplication.datalayer.repository.googlelogin.GoogleLoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class GoogleLoginViewModel(private val googleLoginRep: GoogleLoginRepository) : ViewModel() {

    private val _account = MutableLiveData<GoogleLoginResponse?>()
    val account: LiveData<GoogleLoginResponse?> get() = _account

    fun googleLoginByToken(idToken: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result: ApiResponse<GoogleLoginResponse> = handleApiRequest {
                googleLoginRep.googleLoginForIdToken(idToken)
            }
            when (result) {
                is ApiResponse.Success -> {
                    result.data.data?.let { _account.postValue(result.data) }
                        .also { Timber.d("${_account.value?.data}") }
                }
                is ApiResponse.Error -> { Timber.d("Error: ${result.e}") }
            }
        }
    }

    fun googleSignOut() {
        _account.postValue(GoogleLoginResponse(null, ""))
    }
}