package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    private lateinit var shared: SharedPreferences

    // private val shared = SharedPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPreferences(this)
        setContentView(R.layout.activity_main)
        shared = SharedPreferences(this)
        loginAction()
    }

    private fun loginAction() {
        login_btn.setOnClickListener {
            var login = input_login.text.toString()
            if (login.isNotEmpty()) {
                shared.login = login
                val intent = Intent(this, PasswordAcivity::class.java)
                startActivity(intent)
                finish()
            } else {
                showToast("Поле не должно быть пустым!))")
            }
        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

