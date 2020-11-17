package com.example.firstapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.cityArray
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter

//    private fun setData() {
//        for (i in 1..10) {
//            array.add("Попытка № $i")
//        }
//    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //setData()
            setUpAdapter()
            //addAction()
        }

    private fun setUpAdapter( ) {
        adapter = MainAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        adapter.updateItems(cityArray)
    }

//    private fun addAction() {
//        add.setOnClickListener {
//            val value = input_text.text.toString()
//            if (checkFieldIsEmpty(
//                    value,
//                    this,
//                    "Введите для начала текста"
//                )
//            ) return@setOnClickListener
//            adapter.addItem(value)
//        }
//    }
}