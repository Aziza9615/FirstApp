package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_authorization.*

class RegistationActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        shared = SharedPreferences(this)

        registrationAction()
    }

    private fun registrationAction() {
        reg_btn.setOnClickListener click@{
            val login = login_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            val confirmPassword = confrim_password_edit_text.text.toString()

            if (checkFieldIsEmpty(login, this, "Введите логин")) return@click
            if (checkFieldIsEmpty(password, this, "Введите пароль")) return@click
            if (checkFieldIsEmpty(confirmPassword, this, "Подтвердите пароль")) return@click
            if (checkFieldIsSame(password, confirmPassword, this, "Пароль должен совпадать в двух полях")) return@click

            succesRegistered(login, confirmPassword)
        }
    }

    private fun succesRegistered(login: String, confirmPassword: String) {
        shared.login = login
        shared.password = confirmPassword
        showToast(this, resources.getString(R.string.You_have_successfully_registered))
        finish()
    }
}

