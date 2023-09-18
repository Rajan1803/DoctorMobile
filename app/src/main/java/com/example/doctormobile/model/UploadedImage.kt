package com.example.doctormobile.model

import com.google.gson.annotations.SerializedName

data class UploadedImage(

    @SerializedName("data")
    val data: Data = Data(),

    @SerializedName("status")
    val status: Int = 0,

    @SerializedName("success")
    val success: Boolean = false
)