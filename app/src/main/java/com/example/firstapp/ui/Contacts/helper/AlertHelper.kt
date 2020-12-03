package com.example.firstapp.ui.Contacts.helper

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.Contacts

interface OnDialogListener {
    fun onSingleAction() { }
}

fun showSingleActionDialog( action: () -> Unit, activity: AppCompatActivity, header: String, positive: String, negative: String) {
    val alert = AlertDialog.Builder(activity,R.style.NewsDialogStyle)

    val inflater = activity.layoutInflater.inflate(R.layout.alert_add, null)
    alert.setView(inflater)
    val headerTextView: TextView = inflater.findViewById(R.id.header)
    val positiveButton: Button = inflater.findViewById(R.id.positive)
    val negativeButton: Button = inflater.findViewById(R.id.negative)
    val dialog = alert.create()
    headerTextView.text = header //"Добавление новости"
    positiveButton.text = positive //"Добавить"
    negativeButton.text = negative //"Отменить"

    positiveButton.setOnClickListener {
        action
        dialog.dismiss()
    }
    negativeButton.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}

//class ShowAddEditingDialog(context: Context, var headerTitle: String, var listener: OnAddEditListener, var type: Int): Dialog(context, R.style.NewsDialogStyle) {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.alert_add)
//        header.text = headerTitle
//        negative.setOnClickListener { dismiss() }
//        positive.setOnClickListener {listener.addEditingDialog(type, Contacts
//            (image_edit_text.text.toString(),
//            name_edit_text.text.toString(),
//            lastName_edit_text.text.toString(),
//            email_edit_text.text.toString()))}
//    }
//}

interface OnAddEditListener {
    fun addEditingDialog(type: Int, contacts: Contacts)
}




