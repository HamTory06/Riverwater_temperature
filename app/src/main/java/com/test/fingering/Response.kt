package com.test.fingering

import com.google.gson.annotations.SerializedName


data class Response(
    @SerializedName("station")
    val station: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("temp")
    val temp: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("type")
    val type: String
)