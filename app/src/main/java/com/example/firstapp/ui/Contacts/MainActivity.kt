package com.example.firstapp.ui.Contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.MainViewPagerAdapter
import com.example.firstapp.ui.Contacts.helper.adapter.Pet.PetFragment
import com.example.firstapp.ui.Contacts.helper.adapter.Pet.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    lateinit var adapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        setupViewPager()
    }

    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PetFragment())
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pets -> view_pager.setCurrentItem(0, false)
                R.id.profile -> view_pager.setCurrentItem(1, false)
                R.id.favorite -> view_pager.setCurrentItem(1, false)
            }
            true
        }
    }
}










