package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var shared: SharedPreferences
   // private val shared = SharedPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPreferences(this)
        setContentView(R.layout.activity_main)
        setSharedDataAction()
        getSharedDataAction()
    }

    private fun setSharedDataAction() {
        set_shared_btn.setOnClickListener {
            val value = input_edit_text.text.toString()
            if (!value.isNullOrEmpty()) {
                shared.myPersonalData = "${shared.myPersonalData} $value \n"
                shared.isHasPersonalData = true
            }
            input_edit_text.setText("")
        }
    }

    private fun getSharedDataAction() {
        get_shared_btn.setOnClickListener {
            from_shared_text_view.text = "${shared.myPersonalData} \n isHasData = ${shared.isHasPersonalData}"
        }
    }
}







