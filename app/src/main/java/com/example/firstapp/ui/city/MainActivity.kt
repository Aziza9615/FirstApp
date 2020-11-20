package com.example.firstapp.ui.city


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.News
import com.example.firstapp.R
import com.example.firstapp.newsArray
import com.example.firstapp.showSnackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NewsAdapter.Listener {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        val item = intent.getSerializableExtra("news") as News
    }

    private fun setAdapter() {
        adapter = NewsAdapter(this)
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.adapter = adapter
        adapter.updateItems(newsArray)
    }

    override fun onItemClick(item: News) {
        showSnackbar(recycle_view, item.title)
        val intent = Intent(this, NewsAdapter::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }
}







