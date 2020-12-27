package com.example.firstapp.ui.Contacts.helper.adapter.dog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.cat.Pet
import kotlinx.android.synthetic.main.dog_detail_activity.*

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dog_detail_activity)
        val item = intent.getSerializableExtra("pet") as Pet
        setUpViews(item)
    }

    private fun setUpViews(item: Pet) {
        Glide.with(this)
            .load(item.image)
            .into(image2)

        header2.text = item.name
        title_two2.text = item.description
        val likeDrawable = if (item.isLiked) R.drawable.ic_dizlike
        else R.drawable.ic_like
        like2.setImageResource(likeDrawable)
    }
}