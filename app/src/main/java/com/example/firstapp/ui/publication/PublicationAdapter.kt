package com.example.firstapp.ui.publication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.model.Publication
import com.example.firstapp.ui.image.ImagePublicationAdapter
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import kotlinx.android.synthetic.main.item_main.view.*

class PublicationAdapter(private val listener: ClickListener, private val activity: Activity) : RecyclerView.Adapter<PublicationViewHolder>() {
    private var items = mutableListOf<Publication>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        return PublicationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return items.count()
    }
    override fun onBindViewHolder(holder: PublicationViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, activity)
        holder.itemView.favorites_btn.setOnClickListener {
            listener.onFavoriteClick(item, position)
            holder.itemView.favorites_btn.setImageResource(getFavoriteIcon(item.isFavorite))
        }
        holder.itemView.comments_btn.setOnClickListener {
            listener.onCommentClick(item)
        }
        holder.itemView.directs_btn.setOnClickListener {
            listener.onDirectClick(item)
        }
    }
    fun addItems(items: MutableList<Publication>) {
        this.items = items
        notifyDataSetChanged() // - вы обновляете весь адаптер
    }
    fun updateItem(position: Int) {
        notifyItemChanged(position)
    }
    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRangeRemoved(position, itemCount)
    }
    interface ClickListener {
        fun onFavoriteClick(item: Publication, position: Int)
        fun onCommentClick(item: Publication)
        fun onDirectClick(item: Publication)
    }
}

class PublicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Publication, activity: Activity) {
        Glide.with(itemView.context).load(item.icon).into(itemView.icon_civ)
        itemView.names_tv.text = item.name
        itemView.like.text = "${item.like}"
        if (item.like == 0) itemView.like.visibility = View.GONE
        else itemView.like.visibility = View.VISIBLE
        itemView.favorites_btn.setImageResource(getFavoriteIcon(item.isFavorite))
        setupImagesRecyclerView(item.image, itemView.images_rv, itemView.rvs_pi)
    }

    fun setupImagesRecyclerView(items: MutableList<String>, recyclerView: RecyclerView, pagerIndicator: IndefinitePagerIndicator) {
        val adapter = ImagePublicationAdapter()
        val snapHelper = PagerSnapHelper()
        recyclerView.apply { layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
            this.adapter = adapter
            this.onFlingListener = null
            snapHelper.attachToRecyclerView(this)
            pagerIndicator.attachToRecyclerView(this)
        }
        adapter.addItems(items)
    }
}

private fun getFavoriteIcon(state: Boolean): Int {
    return if (state) R.drawable.ic_favorite
    else R.drawable.ic_unfavorite
}

 //View.VISIBLE = ОТОБРАЖАЕТСЯ
// View.GONE = неотображается и Text view не занимает места
//View.INVISIBLE - НЕ ОТОБРАЖАЕТСЯ НО text view ЗАНИМАЕТ МЕСТА



