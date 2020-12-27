package com.example.firstapp.ui.Contacts.helper.adapter.Favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.cat.Pet
import com.example.firstapp.ui.Contacts.helper.adapter.cat.favoritesArray
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

    private fun setupAdapter() {
        adapter = PetsAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.adapter = adapter
        adapter.addItems(favoritesArray)
    }

    override fun onLikeClick(position: Int, item: Pet) {
        adapter.removeItem(position)
        showSnackbar(recycler_view,
            "Вы удалили из избранного ${item.name}",
            "Восстановить")  { adapter.restoreItem(position, item)}
    }
}
