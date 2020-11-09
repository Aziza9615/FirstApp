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
        reg_btn.setOnClickListener {
            val login = login_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            val confirmPassword = confrim_password_edit_text.text.toString()

            if (login.isEmpty()) {
                showToast(this, resources.getString(R.string.Enter_login))
                return@setOnClickListener
            }

            if (password. isEmpty()) {
            showToast(this, resources.getString(R.string.Enter_password))
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                showToast(this, resources.getString(R.string.Confirm_the_password))
                return@setOnClickListener
            }

            shared.login = login
            shared.password = confirmPassword
            showToast(this, resources.getString(R.string.You_have_successfully_registered))
            finish()
        }
    }
}
