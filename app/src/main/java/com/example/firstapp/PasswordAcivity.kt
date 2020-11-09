package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_password.*

class PasswordAcivity : AppCompatActivity() {
    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        confrimAction()
    }

    private fun confrimAction() {
        chek_password_btn.setOnClickListener {
            val password = password_edit_text.text.toString()
            if (password.isEmpty() && password != shared.password) return@setOnClickListener

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}





