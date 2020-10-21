package com.example.firstapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.constraint_layout.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var name = "Aziza"
    var lastname = "Sadykova"
    var age = 24

    var textArray: MutableList<String> = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)
        setViews()
        saveAction()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun checkFields(value: String, message: String) {
        if (value.isEmpty()) {
            showToast(message)
            return
        }
    }

    private fun setViews() {
        username_value_text_view.text = name
        lastname_value_text_view.text = lastname
        age_value_text_view.text = age.toString()

    }

    private fun saveAction() {
        save_button.setOnClickListener {
            val phone: String = phone_edit_text.text.toString()
            val city: String = city_edit_text.text.toString()
            val region: String = region_edit_text.text.toString()


            checkFields(phone, "Поле номер телефона не может быть пустым")
            checkFields(city, "Поле города не может не быть пустым")
            checkFields(region, "Поле области не может быть пустым")


            Log.v("SAVE_LOG,", "$name, $lastname, $age")
        }
    }
}

