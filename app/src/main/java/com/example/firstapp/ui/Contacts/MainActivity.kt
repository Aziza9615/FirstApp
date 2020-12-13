package com.example.firstapp.ui.Contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.Contact.profile.ProfileFragment
import com.example.firstapp.ui.Contacts.ContactFragment.ContactFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    var contactFragment = ContactFragment()
    var profileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragments()
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.contact -> navigateFragment(contactFragment)
                R.id.profile -> navigateFragment(profileFragment)
                else -> false
            }
        }
    }
    private fun navigateFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, fragment).commit()
        return true
    }

    private fun addFragments() {
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, contactFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, profileFragment).commit()
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, contactFragment).commit()
    }
}









