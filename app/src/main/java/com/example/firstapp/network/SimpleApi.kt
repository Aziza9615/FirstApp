package com.example.firstapp.network

import com.example.firstapp.model.Meet
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {
    // baseUrl = https://lovetest.me
    @GET("/a_test_1/test_app.json")
    fun getMeet(): Call<MutableList<Meet>>
}