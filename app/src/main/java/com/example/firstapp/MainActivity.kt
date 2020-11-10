package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shared = SharedPreferences(this)

        shared.logout = false
        logoutAction()
    }

    private fun logoutAction() {
        logout_button.setOnClickListener click@{
            shared.login = ""
            shared.confirmPassword = ""
            shared.logout = true

            intentToNext(this, LoginActivity::class.java)
        }
    }
}
