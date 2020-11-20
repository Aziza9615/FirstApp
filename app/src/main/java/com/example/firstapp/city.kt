package com.example.firstapp

import java.io.Serializable

data class City(
    var image: Int,
    var name: String,
    var description: String,
    var capital: String,
    var population: String,
    var country: String,
    var sguare: String
) : Serializable
