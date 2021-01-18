package com.example.firstapp.ui.Contacts.helper.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import kotlinx.android.synthetic.main.item_main.*

class DetailNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_name)

        val name = intent?. getStringExtra("name_item")
        name_tv.text = "Вы передали элемент $name"
    }
}