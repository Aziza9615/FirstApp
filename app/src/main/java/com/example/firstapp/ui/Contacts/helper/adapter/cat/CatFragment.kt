package com.example.firstapp.ui.Contacts.helper.adapter.pets.cat

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
import com.example.firstapp.ui.Contacts.helper.adapter.cat.petArray
import com.example.firstapp.ui.Contacts.helper.adapter.dog.PetAdapter
import kotlinx.android.synthetic.main.fragment_cat2.*

class CatFragment : Fragment(), PetAdapter.OnItemClick {

    lateinit var adapter: PetAdapter
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
        adapter = PetAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
    }

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    private fun updateItems() {
        adapter.addItems(petArray)
    }

    override fun onItemClick(item: Pet) {
        val intent = Intent(activity, PetDetailActivity::class.java)
        intent.putExtra("pet", item)
        startActivity(intent)
    }
}
