package com.example.firstapp.ui.Contacts.helper

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R

interface OnDialogListener {
    fun onSingleAction() { }
}

fun showSingleActionDialog( action: () -> Unit, activity: AppCompatActivity, header: String, positive: String, negativ: String) {
    val alert = AlertDialog.Builder(activity,R.style.NewsDialogStyle)

    val inflater = activity.layoutInflater.inflate(R.layout.alert_add, null)
    alert.setView(inflater)
    val headerTextView: TextView = inflater.findViewById(R.id.header)
    val positiveButton: Button = inflater.findViewById(R.id.positive)
    val negativeButton: Button = inflater.findViewById(R.id.negative)
    val dialog = alert.create()
    headerTextView.text = header //"Добавление новости"
    positiveButton.text = positive //"Добавить"
    negativeButton.text = negativ //"Отменить"

    positiveButton.setOnClickListener {
        action
        dialog.dismiss()
    }
    negativeButton.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}



