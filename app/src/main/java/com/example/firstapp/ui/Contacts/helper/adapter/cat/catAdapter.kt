package com.example.firstapp.ui.Contacts.helper.adapter.cat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R

class CatAdapter(private var listener: OnItemClick): RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    var array = mutableListOf<Pet>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val item = array[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.OnItemClick(item)
        }
        holder.like.setOnClickListener {
            val like = !array[position].isLiked
            array[position].isLiked = array[position].isLiked
            item.isLiked = !item.isLiked
            val image = if (item.isLiked) R.drawable.ic_dizlike
            else R.drawable.ic_like

            holder.like.setImageResource(image)
        }
    }

    fun addItems(items: MutableList<Pet>) {
        array = items
        notifyDataSetChanged()
    }

    class CatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val title_two: TextView = itemView.findViewById(R.id.title_two)
        val like: ImageButton = itemView.findViewById(R.id.like)

        fun bind(item: Pet) {
            Glide.with(image.context)
                .load(item.image)
                .into(image)
            title.text = item.name
            title_two.text = item.description

            //            val image = when(item.isLiked) {
//                true -> R.drawable.ic_dizlike
//                false -> R.drawable.ic_like
//            }
            //            val image = when(item.isLiked) {

            like.setImageResource(getLikeImage(item.isLiked))
        }
    }

    fun removeItem(item: Int) {
        //Выполнить логику удаления
    }

    fun restoreItem(item: Pet, position: Int) {
        array.add(position, item)
        notifyItemInserted(position)
    }

    interface OnItemClick {
        val ItemSwipe: Any

        fun OnItemClick(item: Pet)
        fun CatFragment(swipeHandler: ItemSwipe): CatFragment
    }
}

fun getLikeImage(state: Boolean) = if (state)  R.drawable.ic_dizlike
    else R.drawable.ic_like


