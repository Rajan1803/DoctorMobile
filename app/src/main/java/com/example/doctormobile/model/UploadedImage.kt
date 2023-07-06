package com.example.doctormobile.model

data class UploadedImage(
    val `data`: Data = Data(),
    val status: Int = 0,
    val success: Boolean = false
)