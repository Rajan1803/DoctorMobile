package com.example.doctormobile.model

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("delete_url")
    val deleteUrl: String = "",

    @SerializedName("display_url")
    val displayUrl: String = "",

    @SerializedName("expiration")
    val expiration: Int = 0,

    @SerializedName("height")
    val height: Int = 0,

    @SerializedName("id")
    val id: String = "",

    @SerializedName("image")
    val image: Image = Image(),

    @SerializedName("size")
    val size: Int = 0,

    @SerializedName("thumb")
    val thumb: Thumb = Thumb(),

    @SerializedName("time")
    val time: Int = 0,

    @SerializedName("title")
    val title: String = "",

    @SerializedName("url")
    val url: String = "",

    @SerializedName("url_viewer")
    val urlViewer: String = "",

    @SerializedName("width")
    val width: Int = 0
)