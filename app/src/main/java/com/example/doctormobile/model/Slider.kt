package com.example.doctormobile.model

import com.google.gson.annotations.SerializedName

data class Slider(
    @SerializedName("image")
    val image: String = "",

    @SerializedName("sub_title")
    val subTitle: String = "",

    @SerializedName("title")
    val title: String = ""
)