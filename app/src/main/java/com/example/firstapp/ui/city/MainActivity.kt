package com.example.firstapp.ui.city

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.City
import com.example.firstapp.R
import com.example.firstapp.cityArray
import com.example.firstapp.ui.city.detail_city.CityActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
    MainAdapter.Listener {

    private lateinit var adapter: MainAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            setUpAdapter()
        }

    private fun setUpAdapter( ) {
        adapter = MainAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        adapter.updateItems(cityArray)
    }

    override fun onItemClick(item: City) {
        //showToast(this, item.description)
        val intent = Intent(this, CityActivity::class.java)
        intent.putExtra("city", item)
        startActivity(intent)
    }
}