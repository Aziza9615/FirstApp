package com.example.firstapp.ui.city.detail.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.firstapp.News
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val item = intent.getSerializableExtra("news_item") as News
        setUpViews(item)
    }

    fun setUpViews(item: News) {
        Glide
            .with(image.context)
            .load(item.image)
            .into(image)
        header.text = item.title
        description.text = item.description
    }
}