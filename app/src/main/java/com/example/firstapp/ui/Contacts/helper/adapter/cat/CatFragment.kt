package com.example.firstapp.ui.Contacts.helper.adapter.cat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import kotlinx.android.synthetic.main.fragment_cat2.*

class CatFragment : Fragment(), CatAdapter.OnItemClick {

    lateinit var adapter: CatAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cat2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     setupAdapter()
    }

    private fun setupAdapter() {
        adapter = CatAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter.addItems(catArray)
    }

    override fun OnItemClick(item: Pet) {
        val intent = Intent(activity, CatDetailActivity::class.java)
        intent.putExtra("cat", item)
        startActivity(intent)
    }
}