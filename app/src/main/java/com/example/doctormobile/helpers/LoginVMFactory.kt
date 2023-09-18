package com.example.doctormobile.helpers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doctormobile.repository.LoginRepository
import com.example.doctormobile.viewmodel.LoginViewModel

class LoginVMFactory(private val repository: LoginRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }

}
