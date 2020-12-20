package com.example.firstapp.ui.Contacts.helper.adapter.pet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.SharedPreferences
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.item_cat.image

class ProfileFragment : Fragment() {

    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = SharedPreferences(requireContext())
        setupViews()
        editAction()
    }

    private fun setupViews() {
        Glide.with(image.context)
            .load(pref.image)
            .into(image)
        name.setText(pref.name)
        surname.setText(pref.surname)
        phone_number.setText(pref.phoneNumber)
    }

    var isEdit = false
    private fun editAction() {
        edit.setOnClickListener {
            if (!isEdit) setEditState()
            else updateEditingViews()
        }
     }

    private fun setEditState() {
        name.isEnabled = true
        surname.isEnabled = true
        phone_number.isEnabled = true
        edit.text = resources.getString(R.string.save)
        isEdit = true
    }

    private fun updateEditingViews() {
        name.isEnabled = false
        surname.isEnabled = false
        phone_number.isEnabled = false
        edit.text = resources.getString(R.string.edit)
        isEdit = false

        pref.name = name.text.toString()
        pref.surname = surname.text.toString()
        pref.phoneNumber = phone_number.text.toString()
    }
}