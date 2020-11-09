package com.example.firstapp

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
        registration_btn.setOnClickListener click@{
            intentToNext(this, RegistationActivity::class.java)
        }
    }

    private fun loginAction() {
        authorization_btn.setOnClickListener click@{
            val login = input_login.text.toString()
            if (checkFieldIsEmpty(login, this, "Введите Логин")) return@click
            if (checkFieldIsSame(login, shared.login, this, "Логин не найден")) return@click

            intentToNext(this, PasswordActivity::class.java)
            finish()
        }
    }
}


