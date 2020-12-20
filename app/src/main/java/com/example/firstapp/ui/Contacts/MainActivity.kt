package com.example.firstapp.ui.Contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.pet.PetFragment
import com.example.firstapp.ui.Contacts.helper.adapter.pet.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    private var petFragment = PetFragment()
    private var profileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        addStartFragment()
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pet -> navigateFragment(petFragment)
                R.id.profile -> navigateFragment(profileFragment)
                else -> false
            }
        }
    }

    private fun navigateFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment,fragment).commit()
        return true
    }

    private fun addStartFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment,petFragment).commit()
    }
}









