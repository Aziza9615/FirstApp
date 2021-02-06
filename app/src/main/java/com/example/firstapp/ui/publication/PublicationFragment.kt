package com.example.firstapp.ui.publication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.helper.showToast
import com.example.firstapp.model.Publication
import com.example.firstapp.ui.main.MainRepository
import kotlinx.android.synthetic.main.fragment_image.*

interface RequestResult {
    fun onFailure(t: Throwable)
    fun onSuccess(result: MutableList<Publication>)
}

class   PublicationFragment : Fragment(), PublicationAdapter.ClickListener, RequestResult {

    lateinit var adapter: PublicationAdapter

    private var publicationArray: MutableList<Publication> = mutableListOf()
    private lateinit var repository: MainRepository

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
        repository = MainRepository(this)
        repository.fetchPublications()
    }

    override fun onFailure(t: Throwable) {
        showToast(requireContext(),t.message.toString())
    }

    override fun onSuccess(result: MutableList<Publication>) {
        adapter.addItems(result)
    }

    override fun onFavoriteClick(item: Publication, position: Int) {
        publicationArray.forEach {
            if (it == item) {
                it.isFavorite = !it.isFavorite
                if (it.isFavorite) it.countOfFavorite += 1
                else it.countOfFavorite -= 1
                adapter.updateItem(position)
            }
        }

//        it.like += 1
//        it.like -= 1
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


