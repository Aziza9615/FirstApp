package com.example.firstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second_acivity.*

class secondAcivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_acivity)

        getIntentFromPreviusActivity()
        getToMainAction()
    }

    private fun getIntentFromPreviusActivity() {
        val valueFromFirstActivity: String? = intent.getStringExtra("value")
        output.setText(valueFromFirstActivity)
    }

    private fun getToMainAction() {
        go_to_main.setOnClickListener {
            val intent = Intent()
            val output: String = output.text.toString()
            intent.putExtra("modify_value", output)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}




