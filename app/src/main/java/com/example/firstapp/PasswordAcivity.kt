package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        shared = SharedPreferences(this)

        confirmAction()
    }

    private fun confirmAction() {
        check_password_btn.setOnClickListener click@ {
            val password = password_edit_text.text.toString()
            if (checkFieldIsEmpty(password, this, resources.getString(R.string.The_password_was_entered_incorrectly))) return@click
            if (checkFieldIsSame(password, shared.password, this, resources.getString(R.string.Password_entered_incorrectly))) return@click

            intentToNext(this, MainActivity::class.java)
        }

    }
}





