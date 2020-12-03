package com.example.firstapp.ui.Contacts.Contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.Contacts
import com.example.firstapp.ui.Contacts.helper.showToast
import kotlinx.android.synthetic.main.fragment_contact_detail.*

class ContactDetailFragment : Fragment() {

    lateinit var contacts: Contacts

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        contacts = arguments?.getSerializable("item") as Contacts
        showToast(requireContext(), contacts.toString())
        setUpViews()
    }

    private fun setUpViews() {
        Glide.with(image)
            .load(contacts.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)

        name.text = contacts.firstName
        lastName.text = contacts.lastName
        email.text = contacts.email
    }
}

