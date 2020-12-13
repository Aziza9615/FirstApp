package com.example.firstapp.ui.Contacts.Contact.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstapp.R
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.edit as edit1

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        setUpViews()
        editAction()
    }

    private fun setUpViews() {
        Glide.with(this)
            .load(aziza.image)
            .into(image)
        name.text = aziza.name
        age.text = aziza.age
        email.text = aziza.email
        bio.text = aziza.bio
    }

    private fun editAction() {
        edit1.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
