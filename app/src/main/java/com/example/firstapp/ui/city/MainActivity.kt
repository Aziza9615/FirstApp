package com.example.firstapp.ui.city


import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.News
import com.example.firstapp.R
import com.example.firstapp.newsArray
import com.example.firstapp.showSnackbar
import com.example.firstapp.ui.city.detail.activity.NewsDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(), NewsAdapter.Listener,Parcelable {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
    }

    private fun setAdapter() {
        adapter = NewsAdapter(this)
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.adapter = adapter
        adapter.updateItems(newsArray)
    }

    override fun onItemClick(item: News) {
        val intent = Intent(this, NewsDetailActivity::class.java)
        intent.putExtra("news_item", news)
        startActivity(intent)
    }

    private var news: News? = null
    private var position: Int? = null
    
    override fun onLongItemClick(item: News, position: Int) {
        news = item
        this.position = position
        showDeleteAlertDialog()
    }

    private fun deleteItem() {
        showSnackbar(recycle_view, "Новость была удалена", "Востановить", this::restoreNewsItem)
        adapter.deleteItem(position!!)
    }

    private fun restoreNewsItem() {
        if (news != null && position != null) adapter.restoreItem(news!!, position!!)
    }

    private fun showDeleteAlertDialog() {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)
        val dialog = alert.create()
        var inflater = layoutInflater.inflate(R.layout.alert_delete_dialog, null)
        alert.setView(inflater)
        val header: TextView = inflater.findViewById(R.id.header)
        val positive: Button = inflater.findViewById(R.id.positive)
        val negative: Button = inflater.findViewById(R.id.negative)

        header.text = "Вы уверены что хотите удалить?"
        positive.text = "Удалить"
        negative.text = "Отменить"
        positive.setOnClickListener {
            deleteItem()
        }
        negative.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}







