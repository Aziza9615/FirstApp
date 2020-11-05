package com.example.firstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second_acivity.*

class ListOfEgualsAcivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_acivity)

        getListOfEguals()
    }

    private fun getListOfEguals() {
        val value = intent.getStringArrayListExtra("list")
        var result:String = ""
        if (value != null)
        for (i in value) {
            result += "$i \n"
        }
        list_txt.text = result
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}




