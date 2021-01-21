package com.example.firstapp.ui.Contacts.helper.publication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import kotlinx.android.synthetic.main.fragment_image.*


class PublicationFragment : Fragment(), PublicationAdapter.ClickListener {

    lateinit var adapter: PublicationAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image,  false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter =
            PublicationAdapter(
                this,
                requireActivity()
            )
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
        adapter.addItems(publicationArray)
    }

    override fun onFavoriteClick(item: Publication, position: Int) {
        publicationArray.forEach {
            if (it == item) it.isFavorite = !it.isFavorite
        }
        adapter.updateItem(position)
    }

    override fun onCommentClick(item: Publication) {
        TODO("Not yet implemented")
    }

    override fun onDirectClick(item: Publication) {
        TODO("Not yet implemented")
    }
}

