package com.example.firstapp.ui.Contacts.helper.adapter.cat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.showSnackbar
import kotlinx.android.synthetic.main.fragment_cat2.*

class CatFragment : Fragment(), CatAdapter.OnItemClick {

    lateinit var adapter: CatAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cat2, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = CatAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter.addItems(catArray)
    }

    override val ItemSwipe: Any
        get() = TODO("Not yet implemented")

    override fun OnItemClick(item: Pet) {
        val intent = Intent(activity, CatDetailActivity::class.java)
        intent.putExtra("cat", item)
        startActivity(intent)

        val swipeHandler = object : ItemSwipe(activity!!) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }


            fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int,
                recycle_view: View
            ) {
                adapter.array.removeAt(direction)
                adapter.notifyDataSetChanged()

                val position = viewHolder.adapterPosition
                val contact = catArray[position]
                adapter.removeItem(position)
                showSnackbar(recycle_view,"Вы удалили элемент ", "Востановить") { adapter.restoreItem(contact, position) }
            }
        }

        val catFragment = CatFragment(swipeHandler)
        catFragment.attachToRecyclerView(ItemSwipe.recycle_view)
    }

    override fun CatFragment(swipeHandler: ItemSwipe): CatFragment {
        TODO("Not yet implemented")
    }


    fun attachToRecyclerView(recycleView: Any) {
        TODO("Not yet implemented")
    }
}
