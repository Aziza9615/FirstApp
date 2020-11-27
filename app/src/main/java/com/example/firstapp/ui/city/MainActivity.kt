package com.example.firstapp.ui.city


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

class MainActivity: AppCompatActivity(), NewsAdapter.Listener {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        addAction()
    }

    private fun setAdapter() {
        adapter = NewsAdapter(this)
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.adapter = adapter
        adapter.updateItems(newsArray)
    }

    override fun onItemClick(item: News) {
        news = item
        val intent = Intent(this, NewsDetailActivity::class.java)
        intent.putExtra("news_item", item)
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
        val inflater = layoutInflater.inflate(R.layout.alert_delete_dialog, null)
        alert.setView(inflater)
        val header: TextView = inflater.findViewById(R.id.header)
        val positive: Button = inflater.findViewById(R.id.positive)
        val negative: Button = inflater.findViewById(R.id.negative)
        val dialog = alert.create()
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

    private fun addAction() {
        fab.setOnClickListener {
            showAddAlertDialog()
        }
    }

    private fun showAddAlertDialog() {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)
        val inflater = layoutInflater.inflate(R.layout.alert_add, null)
        alert.setView(inflater)
        val header: TextView = inflater.findViewById(R.id.header)
        val positive: Button = inflater.findViewById(R.id.positive)
        val negative: Button = inflater.findViewById(R.id.negative)
        val image: EditText = inflater.findViewById(R.id.image_edit_text)
        val title: EditText = inflater.findViewById(R.id.title_edit_text)
        val description: EditText = inflater.findViewById(R.id.description_edit_text)
        val dialog = alert.create()
        header.text = "Добавление новости"
        positive.text = "Добавить"
        negative.text = "Отменить"
        positive.setOnClickListener {
            addItem(image, title, description, dialog)
        }
        negative.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    // в андроид есть два способа загрузить фото с интернета
    //первый способ - GLIDE
    //второй способ - PICASSO

    private fun addItem(imageEditText: EditText, titleEditText: EditText, descriptionEditText: EditText, dialog: AlertDialog) {
        var error = 0
        if(isEmptyInputData(imageEditText, "Для добавления элемента нужно добавить картинку")) error += 1
        if(isEmptyInputData(titleEditText, "Для добавления элемента нужно добавить заголовок")) error += 1
        if(isEmptyInputData(descriptionEditText, "Для добавления элемента нужно добавить описание")) error += 1

        if (error > 0) return
        val news = News(imageEditText.text.toString(), titleEditText.text.toString(), descriptionEditText.text.toString())
        adapter.addItem(news)

        dialog.dismiss()
    }

    private fun isEmptyInputData(view: EditText, message: String): Boolean {
        if (view.text.isNullOrEmpty()) {
            view.error = message
            return true
        }
        return false

    }
}






