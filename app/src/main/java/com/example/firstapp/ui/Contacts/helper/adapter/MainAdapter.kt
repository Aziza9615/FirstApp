package com.example.firstapp.ui.Contacts.helper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(private val listener: ClickListener) : RecyclerView.Adapter<MainViewHolder>() {
    
    private var items = mutableListOf<Contact>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, null, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    fun addItems(items: MutableList<Contact>) {
        this.items = items
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onItemClick(item: Contact)
    }
}

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: Contact) {
            itemView.name_tv.text = item.name
            itemView.phone_number_tv.text = item.phoneNumber
            itemView.age_tv.text = "Age: ${item.age}"
        }
    }

