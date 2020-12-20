package com.example.firstapp.ui.Contacts.helper.adapter.dog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.cat.Pet
import kotlinx.android.synthetic.main.fragment_cat2.*

class DogFragment : Fragment(), DogAdapter.OnItemClick {

    lateinit var adapter: DogAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dog, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = DogAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter.addItems(dogArray)
    }

    override fun OnItemClick(item: Pet) {
        val intent = Intent(activity, DogDetailActivity::class.java)
        intent.putExtra("dog", item)
        startActivity(intent)

    }
}