package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val array: MutableList<String> = mutableListOf<String>()
    val list: List<String> = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextActivityAction()
    }

    private fun nextActivityAction() {
        go_to_next.setOnClickListener {
            val intent = Intent(this, secondAcivity::class.java)
            val valueFromEditText: String = input.text.toString()
            intent.putExtra("value", valueFromEditText)
            array.add(valueFromEditText)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        val modifyData: String? = data.getStringExtra("modify_value")
        input.setText(modifyData)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}




