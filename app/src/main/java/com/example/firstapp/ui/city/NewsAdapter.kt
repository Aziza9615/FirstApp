package com.example.firstapp.ui.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.News
import com.example.firstapp.R

    class NewsAdapter(private var listener: Listener): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var newsArray = mutableListOf<News>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    fun updateItems(items: MutableList<News>) {
        newsArray = items
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        newsArray.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    fun restoreItem(item: News, position: Int) {
        newsArray.add(position, item)
        notifyItemRangeChanged(position, itemCount)
    }

    fun addItem(item: News) {
        newsArray.add(item)
        notifyItemInserted(newsArray.lastIndex)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newsArray[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
        holder.itemView.setOnLongClickListener {
            listener.onLongItemClick(item, position)
            true
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var title: TextView = itemView.findViewById(R.id.title)
        var description: TextView = itemView.findViewById(R.id.description)

        fun bind(item: News) {
            Glide
                .with(image.context)
                .load(item.image)
                .into(image)

            title.text = item.title
            description.text = item.description
        }
    }

        interface Listener {
            fun onLongItemClick(item: News, position: Int)
            fun onItemClick(item: News)

        }
    }


