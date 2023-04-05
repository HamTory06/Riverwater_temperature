package com.test.fingering

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface API {
    @GET("/")
    fun get():Call<Response>
}