package com.example.firstapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.helper.showToast
import com.example.firstapp.model.Meet
import com.example.firstapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class newActivity : AppCompatActivity() {

    //lateinit var mainActivity: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        request()
    }

        private fun request() = RetrofitClient().simpleApi.getMeet().enqueue(object :
            Callback<MutableList<Meet>> {
            override fun onFailure(call: Call<MutableList<Meet>>, t: Throwable) {
                showToast(this@newActivity, t.message.toString())
            }

            override fun onResponse(
                call: Call<MutableList<Meet>>,
                response: Response<MutableList<Meet>>
            ) {
                showToast(this@newActivity, response.body().toString())
            }
        })
    }