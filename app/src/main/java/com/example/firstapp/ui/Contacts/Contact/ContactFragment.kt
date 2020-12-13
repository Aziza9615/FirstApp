package com.example.firstapp.ui.Contacts.ContactFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.Contact.ContactAdapter
import com.example.firstapp.ui.Contacts.Contact.ContactDetailFragment
import com.example.firstapp.ui.Contacts.Contacts
import com.example.firstapp.ui.Contacts.contactArray
import com.example.firstapp.ui.Contacts.helper.ItemSimpleTouch
import com.example.firstapp.ui.Contacts.helper.OnAddEditListener
import com.example.firstapp.ui.Contacts.helper.ShowAddEditingDialog
import com.example.firstapp.ui.Contacts.helper.showSnackbar
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment(), ContactAdapter.OnItemClick, OnAddEditListener {

    private lateinit var adapter: ContactAdapter
    lateinit var mContext: Context
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onStart() {
        super.onStart()
        setAdapter()
        addAction()
    }

    private fun setAdapter() {
        adapter = ContactAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        adapter.addItems(contactArray)

        val swipeHandler = object : ItemSimpleTouch(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.array.removeAt(direction)
                adapter.notifyDataSetChanged()
                //Вызвать отображение  SnackBar с возможностью востановить элемент
                val position = viewHolder.adapterPosition
                val contact = contactArray[position]
                adapter.removeItem(position)
                showSnackbar(fab, "Вы удалили контакт", "Востановить") { adapter.restoreItem(position, contact) }
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    override fun onItemClick(item: Contacts, fragment: Any) {
        val bundle = Bundle()
        bundle.putSerializable("item", item)

        val fragment = ContactDetailFragment()
        fragment.arguments = bundle

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container_fragment, fragment ,fragment.tag)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }

    override fun onItemClick(item: Contacts) {
    }


    private fun addAction() {
        fab.setOnClickListener {
            activity?.let {
                ShowAddEditingDialog(it, "Добавление контакта", this, 0).show()
            }
        }
    }


    fun checkIsEmptyField(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()) {
            editText.error = "Обязательное поле"
            return true
        }
        return false
    }

    override fun addEditingDialog(type: Int, contacts: Contacts) {
        adapter.addItem(contacts)
    }
}