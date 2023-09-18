package com.example.doctormobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctormobile.model.Hospital
import com.example.doctormobile.repository.DoctorDataRepository

class DoctorViewModel : ViewModel() {

    private val hospitalLiveData = MutableLiveData<Hospital>()
    val hospitalData: LiveData<Hospital>
        get() = hospitalLiveData

    fun callApi() {
        val doctorDataRepository = DoctorDataRepository()
        doctorDataRepository.callApi { response ->
            hospitalLiveData.postValue(response)
        }
    }
}