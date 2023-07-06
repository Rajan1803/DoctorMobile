package com.example.doctormobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctormobile.model.Hospital
import com.example.doctormobile.network.ApiClient
import com.example.doctormobile.repository.DoctorDataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorViewModel: ViewModel() {

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