package com.example.firstapp.ui.city


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.News
import com.example.firstapp.R
import com.example.firstapp.newsArray
import com.example.firstapp.showSnackbar
import com.example.firstapp.ui.city.detail.activity.NewsDetailActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NewsAdapter.Listener {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
    }

    private fun setAdapter() {
        adapter = NewsAdapter(this)
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.adapter = adapter
        adapter.updateItems(newsArray)
    }

    private var news: News? = null
    override fun onItemClick(item: News) {
        news = item
        showSnackbar(recycle_view, item.title, "Перейти", this::openDetailNews)
    }

    private fun openDetailNews() {
        val intent = Intent(this, NewsDetailActivity::class.java)
        intent.putExtra("news_item", news)
        startActivity(intent)
    }
}







