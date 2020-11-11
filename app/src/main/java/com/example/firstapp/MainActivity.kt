package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var textArray = mutableListOf<String>()

    //private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //shared = SharedPreferences(this)
        addArray()
        removeArray()
    }

    private fun addArray() {
        add_button.setOnClickListener click@{
            val value: String = add_edit_text.text.toString()
                add_edit_text.text.clear()
            showToast(this, resources.getString(R.string.Item_not_found))
                textArray.add(value)
                displayArray()
            }
        }

    private fun removeArray() {
        remove_button.setOnClickListener {
            val value: String = remove_edit_text.text.toString()
                remove_edit_text.text.clear()
                showToast(this, resources.getString(R.string.Cant_add_empty_value))
                textArray.remove(value)
                displayArray()
            }
        }

    private fun displayArray() {
        var result = ""
        for (text: String in textArray) {
            result = "$result + $text \n"
        }
    }
}