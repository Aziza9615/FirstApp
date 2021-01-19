package com.example.firstapp.ui.Contacts.helper.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.publication.PublicationFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        setupBottomNavigationView()
    }

        private fun setupViewPager() {
            adapter = MainViewPagerAdapter(this)
            adapter.addFragment(PublicationFragment())
            adapter.addFragment(PublicationFragment())
            adapter.addFragment(ProfileFragment())
            view_pager.adapter = adapter
            view_pager.isUserInputEnabled = false;
        }

        private fun setupBottomNavigationView() {
            bottom_navigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.image -> changeCurrentItem(0)
                    R.id.image1 -> changeCurrentItem(1)
                    R.id.profile  -> changeCurrentItem(2)
                }
                true
            }
        }

        private fun changeCurrentItem(position: Int) {
            view_pager.setCurrentItem(position, false)
    }
}








