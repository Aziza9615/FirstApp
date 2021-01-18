package com.example.firstapp.ui.Contacts.helper.adapter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setupAdapter()
        btnActivity()
    }

    private fun btnActivity() {
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}



//    private fun setupAdapter () {
//        adapter = MainAdapter()
//        rv.layoutManager = LinearLayoutManager(this)
//        adapter = adapter
//    }











