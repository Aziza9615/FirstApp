package com.example.firstapp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.model.Publication
import com.example.firstapp.ui.publication.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoriteFragment : Fragment(), PublicationAdapter.ClickListener {

    lateinit var adapter: PublicationAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    private fun setupRecyclerView() {
        adapter = PublicationAdapter(this, requireActivity())
        rv_fav.layoutManager = LinearLayoutManager(requireContext())
        rv_fav.adapter = adapter
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        //adapter.addItems(getFavoritesPublications())
    }

//    private fun getFavoritesPublications(): MutableList<Publication> {
//        return publicationArray.filter { it.isFavorite } as MutableList<Publication>
//    }

    override fun onFavoriteClick(item: Publication, position: Int) {
//        publicationArray.forEach {
//            if (it == item) it.isFavorite = !it.isFavorite
//        }
//        adapter.removeItem(position)
    }

    override fun onCommentClick(item: Publication) {
        TODO("Not yet implemented")
    }

    override fun onDirectClick(item: Publication) {
        TODO("Not yet implemented")
    }
}

