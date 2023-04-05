package com.test.fingering

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val url = "https://api.hangang.msub.kr/"
    var retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: API = retrofit.create(API::class.java)
}