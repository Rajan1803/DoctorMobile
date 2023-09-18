package com.example.doctormobile.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("caterogry")
    val category: String = "",

    @SerializedName("doctors")
    val doctors: List<Doctor> = listOf()
)