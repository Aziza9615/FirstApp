package com.example.firstapp.ui.Contacts.helper.adapter.cat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_cat_detail.*
import kotlinx.android.synthetic.main.item_cat.image
import kotlinx.android.synthetic.main.item_cat.like
import kotlinx.android.synthetic.main.item_cat.title_two

class CatDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_detail)
          val item = intent.getSerializableExtra("cat") as Pet
        setUpViews(item)
    }

    private fun setUpViews(item: Pet) {
        Glide.with(this)
            .load(item.image)
            .into(image)

        header.text = item.name
        title_two.text = item.description
        val likeDrawable = if (item.isLiked) R.drawable.ic_dizlike
        else R.drawable.ic_like
        like.setImageResource(likeDrawable)
    }
}