package com.example.doctormobile.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

interface DownloadApiService {
    @GET("golden-retriever-royalty-free-image-506756303-1560962726.jpg")
    @Streaming
    fun download(): Call<ResponseBody>

}