package com.oxygenvideo.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.oxygenvideo.ui.adapter.MainViewPagerAdapter
import com.example.tablayout.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainAdapter =
            MainViewPagerAdapter(
                supportFragmentManager
            )
        viewPager.apply {
            //setAdapter
            adapter = mainAdapter
            //set缓存页数
            offscreenPageLimit = 1
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    //当vp页面改变后也会改变bnv的item选中状态
                    bottomNavigationView.menu.getItem(position).isChecked = true
                }
            })
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            //当bnv选中后会改变vp的显示页面
            when (item.itemId) {
                R.id.nav_home -> {
                    viewPager.currentItem = 0
                }
                R.id.nav_message -> {
                    viewPager.currentItem = 1
                }
                R.id.nav_person -> {
                    viewPager.currentItem = 2
                }
            }
            true
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(object:BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when (p0.itemId) {
                    R.id.nav_home -> {
                        viewPager.currentItem = 0
                    }
                    R.id.nav_message -> {
                        viewPager.currentItem = 1
                    }
                    R.id.nav_person -> {
                        viewPager.currentItem = 2
                    }
                }
                return false
            }
        })
    }
}