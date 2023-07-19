package com.example.doctormobile.repository

import android.util.Log
import com.example.doctormobile.network.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response


class DownloadUploadRepository {
    fun download(completionHandler: (ResponseBody?) -> Unit) {
            ApiClient.downloadFile.download().enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    completionHandler(response.body())
                }
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("Download", "onFailure: ${t.message}")
                }
            })
    }
}