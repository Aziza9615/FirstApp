package com.example.firstapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import com.example.firstapp.helper.showToast
import com.example.firstapp.model.Meet
import com.example.firstapp.network.RetrofitClient
import com.example.firstapp.ui.favorites.FavoriteFragment
import com.example.firstapp.ui.profile.ProfileFragment
import com.example.firstapp.ui.publication.PublicationFragment
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        setupBottomNavigationView()
        request()
    }
    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(this)
        adapter.addFragment(PublicationFragment())
        adapter.addFragment(FavoriteFragment())
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
        view_pager.offscreenPageLimit = 3
        view_pager.isEnabled = false
        view_pager.isUserInputEnabled = false;
    }

        private fun setupBottomNavigationView() {
            bottom_navigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.image -> changeCurrentItem(0)
                    R.id.favorite -> changeCurrentItem(1)
                    R.id.profile  -> changeCurrentItem(2)
                }
                true
            }
        }

        private fun changeCurrentItem(position: Int) {
            view_pager.setCurrentItem(position, false)
    }

    fun request() = RetrofitClient().simpleApi.getMeet().enqueue(object : Callback<MutableList<Meet>> {
        override fun onFailure(call: Call<MutableList<Meet>>, t: Throwable) {
            showToast(this@MainActivity, t.message.toString())
        }

        override fun onResponse(call: Call<MutableList<Meet>>, response: Response<MutableList<Meet>>) {
            showToast(this@MainActivity, response.body().toString())
        }
    })
}
                //ИНТЕНТ ПЕРЕДАЕТ ИЗ ОДНОГО АКТИВИТИ ВО ВТОРУЮ
                 //val intent = Intent(this, MainActivity::class.java)
                //        intent.putExtra("name", "It academy")
               //startActivity(intent)








