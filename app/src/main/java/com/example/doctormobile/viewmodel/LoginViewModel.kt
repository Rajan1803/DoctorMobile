package com.example.doctormobile.viewmodel

import androidx.lifecycle.ViewModel
import com.example.doctormobile.model.LoginResponse
import com.example.doctormobile.repository.LoginRepository

class LoginViewModel(val loginRepository: LoginRepository): ViewModel() {

    fun postLoginData(username: String?, password: String?, completionHandler: ((LoginResponse?) -> Unit)) {
        loginRepository.postLoginData(username,password){ response ->
            completionHandler(response)
        }
    }

}