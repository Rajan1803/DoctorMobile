package com.example.doctormobile.network

import com.example.doctormobile.model.UploadedImage
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface UploadService {
    @Multipart
    @POST("/1/upload")
    fun postImage(@Query("key") key:String,@Part image: MultipartBody.Part): Call<UploadedImage>

}