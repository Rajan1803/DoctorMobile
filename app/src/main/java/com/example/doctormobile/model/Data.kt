package com.example.doctormobile.model

data class Data(
    val delete_url: String = "",
    val display_url: String = "",
    val expiration: Int = 0,
    val height: Int = 0,
    val id: String = "",
    val image: Image = Image(),
    val size: Int = 0,
    val thumb: Thumb = Thumb(),
    val time: Int = 0,
    val title: String = "",
    val url: String = "",
    val url_viewer: String = "",
    val width: Int = 0
)