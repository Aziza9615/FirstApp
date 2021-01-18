package com.example.firstapp.ui.Contacts.helper.adapter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.ClickListener {

    lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = MainAdapter(this)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        adapter.addItems(contactsArray)
    }

    override fun onItemClick(item: Contact) {
        Toast.makeText(this, "Нажатый элемент ${item.name}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailNameActivity::class.java)
        intent.putExtra("name_item", item.name)
        startActivity(intent)
    }
}











