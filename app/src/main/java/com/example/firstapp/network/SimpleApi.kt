package com.example.firstapp.network

import com.example.firstapp.model.Publication
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {
    @GET("raw/feddd59ced26e92850a45d5e048ec5c3b277e098/Publication.json")
    fun fetchPublications(): Call<MutableList<Publication>>
}

//    baseUrl = https://lovetest.me
//    @GET("/a_test_1/test_app.json")
//    fun getMeet(): Call<MutableList<Meet>>