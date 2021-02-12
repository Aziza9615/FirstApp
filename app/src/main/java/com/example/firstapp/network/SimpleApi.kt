package com.example.firstapp.network

import com.example.firstapp.model.Publication
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {
    @GET("/Sirius1888/6551973ba9c39ba44adadfef166e7cb5/raw/aecf079d3f312456be5cce39adeef9fb38013972/Publication.json")
    fun fetchPublications(): Call<MutableList<Publication>>

    @GET("/Sirius1888/6551973ba9c39ba44adadfef166e7cb5/raw/aecf079d3f312456be5cce39adeef9fb38013972/Publication.json")
    fun fetchProfile(): Call<Publication>
}

//    baseUrl = https://lovetest.me
//    @GET("/a_test_1/test_app.json")
//    fun getMeet(): Call<MutableList<Meet>>