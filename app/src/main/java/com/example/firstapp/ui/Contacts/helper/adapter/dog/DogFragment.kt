package com.example.firstapp.ui.Contacts.helper.adapter.pets.dog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.cat.Pet
import com.example.firstapp.ui.Contacts.helper.adapter.cat.PetDetailActivity
import com.example.firstapp.ui.Contacts.helper.adapter.cat.dogArray
import com.example.firstapp.ui.Contacts.helper.adapter.dog.PetAdapter
import kotlinx.android.synthetic.main.fragment_cat2.*

class DogFragment : Fragment(), PetAdapter.OnItemClick {

    lateinit var adapter: PetAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = PetAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter.addItems(dogArray)
    }

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    private fun updateItems() {
        adapter.addItems(dogArray)
    }

    override fun onItemClick(item: Pet) {
        val intent = Intent(activity, PetDetailActivity::class.java)
        intent.putExtra("pet", item)
        startActivity(intent)
    }
}
