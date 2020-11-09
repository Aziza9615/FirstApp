package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var shared: SharedPreferences

    // private val shared = SharedPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPreferences(this)
        setContentView(R.layout.activity_login)
        shared = SharedPreferences(this)
        loginAction()
        registrationAction()
    }

    private fun registrationAction() {
        registration_btn.setOnClickListener {
            val  intent = Intent(this, RegistationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginAction() {
        authorization_btn.setOnClickListener {
            val login = input_login.text.toString()
            if (login.isNotEmpty()) {

                if (login != shared.login) {
                    showToast(this, resources.getString(R.string.Login_is_not_find))
                    input_login.setText("")
                    return@setOnClickListener
                }
                val intent = Intent(this, PasswordAcivity::class.java)
                startActivity(intent)
                finish()
            } else {
                showToast(this, resources.getString(R.string.field_cannot_be_emty))
            }
        }
    }
}


