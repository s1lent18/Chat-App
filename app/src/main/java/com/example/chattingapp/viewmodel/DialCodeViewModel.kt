package com.example.chattingapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chattingapp.data.api.RetrofitInstance
import com.example.chattingapp.data.model.DialCodeModel
import com.example.chattingapp.data.response.NetworkResponse
import kotlinx.coroutines.launch

class DialCodeViewModel : ViewModel() {

    private val codeapi = RetrofitInstance.codeapi
    private val _coderesult = MutableLiveData<NetworkResponse<DialCodeModel>>()
    val coderesult: LiveData<NetworkResponse<DialCodeModel>> = _coderesult

    fun getCodes() {
        _coderesult.value = NetworkResponse.Loading

        viewModelScope.launch {
            try {
                val response = codeapi.getCodes()
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.i("Response:", response.body().toString())
                        _coderesult.value = NetworkResponse.Success(it)
                    }
                } else {
                    _coderesult.value = NetworkResponse.Failure("Invalid Input")
                }
            } catch (e: Exception) {
                _coderesult.value = NetworkResponse.Failure("Invalid Input")
            }

        }
    }
}