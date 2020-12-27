package com.example.firstapp.ui.Contacts.helper.adapter.Favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.cat.Pet
import com.example.firstapp.ui.Contacts.helper.adapter.cat.changeState
import com.example.firstapp.ui.Contacts.helper.adapter.cat.getFavoritesArray
import com.example.firstapp.ui.Contacts.helper.adapter.cat.petArray
import com.example.firstapp.ui.Contacts.helper.showSnackbar
import kotlinx.android.synthetic.main.fragment_cat2.*

class FavoritesPetsFragment : Fragment(), PetsAdapter.OnItemClick {

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

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    private fun setupAdapter() {
        adapter = PetsAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.adapter = adapter
    }

    private fun updateItems() {
        adapter.addItems(getFavoritesArray)
    }

    override fun onLikeClick(position: Int, item: Pet) {
        adapter.removeItem(position)
        changeItems(item)
        showSnackbar(recycler_view,
            "Вы удалили из избранного ${item.name}",
            "Восстановить")  { adapter.restoreItem(position, item)}
    }

    private fun changeItems(item: Pet) {
        changeState(item, petArray)
        changeState(item, petArray)
    }
}
