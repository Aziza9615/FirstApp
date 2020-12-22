package com.example.firstapp.ui.Contacts.helper.adapter.Pet

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.SharedPreferences
import com.example.firstapp.ui.Contacts.helper.adapter.checkPermissions
import com.example.firstapp.ui.Contacts.helper.showSnackbar
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
        phoneAction()
    }

    private fun setupViews() {
        Glide.with(image.context)
            .load(pref.image)
            .into(image)
        name.setText(pref.name)
        surname.setText(pref.surname)
        phone_number.setText(pref.phoneNumber)
    }

    private fun editAction() {
        edit.setOnClickListener {
            if (!name.isEnabled) changeState(true, resources.getString(R.string.save))
            else changeState(false, resources.getString(R.string.edit))
        }
    }

    private fun changeState(state: Boolean, editTitle: CharSequence) {
        name.isEnabled = state
        surname.isEnabled = state
        phone_number.isEnabled = state
        edit.text = editTitle

        if (!state) updatePrefs()
    }

    private fun phoneNumber() = phone_number.text.toString()

    private fun updatePrefs() {
        pref.name = name.text.toString()
        pref.surname = surname.text.toString()
        pref.phoneNumber = phoneNumber()
    }

    private fun phoneAction() {
        image_call.setOnClickListener {
            if (phoneNumber().isEmpty()) showSnackbar(phone_number,"Номер отсутствует")
            else checkPermissions(requireActivity(), Manifest.permission.CALL_PHONE) {openPhone(phoneNumber())}
        }
    }

    private fun openPhone(number: String) {
        val intent = Intent(Intent(ACTION_CALL))
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }
}