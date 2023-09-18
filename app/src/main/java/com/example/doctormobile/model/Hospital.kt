package com.example.doctormobile.model

import com.google.gson.annotations.SerializedName

data class Hospital(
    @SerializedName("categories")
    val categories: List<Category> = listOf(),

    @SerializedName("slider")
    val slider: List<Slider> = listOf()
)