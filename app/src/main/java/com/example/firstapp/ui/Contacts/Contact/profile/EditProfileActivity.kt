package com.example.firstapp.ui.Contacts.Contact.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.Contacts
import kotlinx.android.synthetic.main.alert_add.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
    }

    val contacts = Contacts(
        image_edit_text.text.toString(),
        name_edit_text.text.toString(),
        lastName_edit_text.text.toString(),
        email_edit_text.text.toString()
    )
}