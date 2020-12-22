package com.example.firstapp.ui.Contacts.helper.adapter.Pet


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.ui.Contacts.helper.adapter.Favorite.FavoritesPetsFragment
import com.example.firstapp.ui.Contacts.helper.adapter.cat.CatFragment
import com.example.firstapp.ui.Contacts.helper.adapter.dog.DogFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_pet.*

class PetFragment : Fragment() {

    private lateinit var viewPagerAdapter: PetViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupTabLayout()
    }

    private fun setupViewPager() {
        viewPagerAdapter = PetViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.addFragment(CatFragment(), "Котики")
        viewPagerAdapter.addFragment(DogFragment(),"Собаки")
        viewPagerAdapter.addFragment(FavoritesPetsFragment(),"Favorite")
        view_pager.adapter = viewPagerAdapter
    }

    private fun setupTabLayout() {
        tab_layout.setupWithViewPager(view_pager)
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                view_pager.currentItem = tab.position
            }

        })
    }
}