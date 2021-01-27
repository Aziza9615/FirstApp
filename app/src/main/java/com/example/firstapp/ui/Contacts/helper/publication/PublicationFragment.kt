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
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = PublicationAdapter(this, requireActivity())
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.addItems(publicationArray)
    }

    override fun onFavoriteClick(item: Publication, position: Int) {
        publicationArray.forEach {
            if (it == item) {
                it.isFavorite = !it.isFavorite
            }
        }
    }

    override fun onCommentClick(item: Publication) {
    }

    override fun onDirectClick(item: Publication) {
    }
}

//    var i = 0
//    //Сработает хотя бы 1 раз
//    do {
//        Log.v("DO_WHILE", "COUNT IS $i")
//    } while (i == 0)
//
//    //Сработает ровное количество раз
//    while (i < 3) {
//        Log.v("WHILE", "COUNT IS $i")
//    }
//
//    //Сработает ровное количество раз
//    for (i in 1..3) {
//        Log.v("FOR", "COUNT IS $i")
//    }
//}


