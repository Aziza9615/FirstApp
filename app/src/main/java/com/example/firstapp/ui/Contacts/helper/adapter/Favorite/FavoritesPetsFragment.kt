package com.example.firstapp.ui.Contacts.helper.adapter.Favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.cat.Pet
import com.example.firstapp.ui.Contacts.helper.adapter.cat.petsArray
import kotlinx.android.synthetic.main.fragment_cat2.*

class FavoritesPetsFragment : Fragment() {

    lateinit var adapter: PetsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorites_pets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = PetsAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter.addItems(petsArray)
    }

    fun OnItemClick(item: Pet) {
        val intent = Intent(activity, Pets_Detail_Activity::class.java)
        intent.putExtra("favorites", item)
        startActivity(intent)

    }
}
