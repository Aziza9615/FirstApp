package com.example.firstapp.ui.detail_publication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.model.Publication
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import kotlinx.android.synthetic.main.fragment_detail_publication.*
import kotlinx.android.synthetic.main.fragment_detail_publication.icon_civ
import kotlinx.android.synthetic.main.fragment_detail_publication.images_rv
import kotlinx.android.synthetic.main.fragment_detail_publication.like
import kotlinx.android.synthetic.main.item_main.*

class DetailPublicationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_publication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("publication") as Publication

        Glide.with(requireContext()).load(data.icon).into(icon_civ)
        name_tv.text = data.name
        like.text = "${data.like}"
        setupImagesRecyclerView(data.image, images_rv, rvs_pi)
    }

    private fun setupImagesRecyclerView(
        image: MutableList<String>,
        imagesRv: RecyclerView?,
        rvsPi: IndefinitePagerIndicator?
    ) {

        
    }
}