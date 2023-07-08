package com.example.doctormobile.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctormobile.repository.DownloadUploadRepository
import okhttp3.ResponseBody

class DownloadViewModel: ViewModel() {

    val downloadedLiveData = MutableLiveData<ResponseBody>()

    val downloadedData: LiveData<ResponseBody>
        get() = downloadedLiveData


    fun download() {
        val repository = DownloadUploadRepository()
        repository.download { responseBody ->
            downloadedLiveData.postValue(responseBody)
        }
    }
}