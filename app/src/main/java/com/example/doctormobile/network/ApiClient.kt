package com.example.doctormobile.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var interceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val hospitalApiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://mocki.io")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    val loginApiService: LoginApiService by lazy {

        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(LoginApiService::class.java)
    }

    val uploadService: UploadService by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder()
            .baseUrl("https://api.imgbb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(UploadService::class.java)
    }

    val downloadFile: DownloadApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://hips.hearstapps.com/hmg-prod/images/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(DownloadApiService::class.java)
    }

}