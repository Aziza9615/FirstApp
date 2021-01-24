package com.example.firstapp.ui.Contacts.helper.publication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.image.ImagePublicationAdapter
import kotlinx.android.synthetic.main.item_main.view.*

class PublicationAdapter(private val listener: ClickListener, private val activity: Activity) : RecyclerView.Adapter<PublicationViewHolder>() {

    private var items = mutableListOf<Publication>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        return PublicationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        )
    }

//    override fun onResume() {
//        super.onResume()
//        adapter.addItems
//    }


    override fun getItemCount(): Int {
        return items.count()
    }


    override fun onBindViewHolder(holder: PublicationViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, activity)
        holder.itemView.favorite_btn.setOnClickListener {
            listener.onFavoriteClick(item, position)
        }
        holder.itemView.comment_btn.setOnClickListener {
            listener.onCommentClick(item)
        }
        holder.itemView.direct_btn.setOnClickListener {
            listener.onDirectClick(item)
        }
    }

    fun addItems(items: MutableList<Publication>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun updateItem(position: Int) {
        notifyItemChanged(position)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemChanged(position, items)
    }

    fun restoreItem(position: Int, item: Publication) {
        items.add(position, item)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, items.size)
    }


    interface ClickListener {
        fun onFavoriteClick(item: Publication, position: Int)
        fun onCommentClick(item: Publication)
        fun onDirectClick(item: Publication)
        fun updateItem()
    }
}


class PublicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Publication, activity: Activity) {
        itemView.name.text = item.name
        itemView.favorite_btn.setImageResource(getFavoriteIcon(item.isFavorite))
        setupRecyclerView(item.image, activity)
    }

    private fun getFavoriteIcon(state: Boolean): Int {
        return if (state) R.drawable.ic_favorite
        else R.drawable.ic_unfavorite
    }


    private fun setupRecyclerView(items: MutableList<String>, activity: Activity) {
        val adapter = ImagePublicationAdapter()
        itemView.images_rv.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        itemView.images_rv.adapter = adapter
        adapter.addItems(items)
        // тут надо связать 
    }
}
