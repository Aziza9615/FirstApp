package com.example.firstapp.ui.Contacts


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        addAction()
    }

    private fun setAdapter() {
        adapter = ContactAdapter()
        recycle_view.adapter = adapter
        recycle_view.layoutManager = LinearLayoutManager(this)
        adapter.addItems(contactArray)

    }

    private fun addAction() {
        fab.setOnClickListener {
            showAddingMemberActionDialog()
        }
    }

    fun showAddingMemberActionDialog() {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)

        val inflater = layoutInflater.inflate(R.layout.alert_add, null)
        alert.setView(inflater)
        val headerTextView: TextView = inflater.findViewById(R.id.header)
        val positiveButton: Button = inflater.findViewById(R.id.positive)
        val negativeButton: Button = inflater.findViewById(R.id.negative)

        val imageEditText: EditText = inflater.findViewById(R.id.image_edit_text)
        val nameEditText: EditText = inflater.findViewById(R.id.name_edit_text)
        val lastNameEditText: EditText = inflater.findViewById(R.id.lastName_edit_text)
        val emailEditText: EditText = inflater.findViewById(R.id.email_edit_text)

        val dialog = alert.create()
        headerTextView.text = "Добавление контакта"
        positiveButton.text = "Добавить"
        negativeButton.text = "Отменить"

        negativeButton.setOnClickListener {
            dialog.dismiss()
        }

        positiveButton.setOnClickListener {
            addNewContact(imageEditText, nameEditText, lastNameEditText, emailEditText, dialog)
        }
        dialog.show()
    }

    private fun addNewContact(imageEditText: EditText, nameEditText: EditText, lastNameEditText: EditText, emailEditText: EditText, dialog: AlertDialog) {
        val image = imageEditText.text.toString()
        val name = nameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val email = emailEditText.text.toString()
        var errorCount = 0

        if (checkIsEmptyField(imageEditText)) errorCount +=1
        if (checkIsEmptyField(nameEditText)) errorCount +=1
        if (checkIsEmptyField(lastNameEditText)) errorCount +=1
        if (checkIsEmptyField(emailEditText)) errorCount +=1

        if (errorCount > 0) return

        adapter.addItem(Contacts(image, name, lastName, email))
        dialog.dismiss()
    }

    fun checkIsEmptyField(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()) {
            editText.error = "Обязательное поле"
            return true
        }
        return false
    }

}






