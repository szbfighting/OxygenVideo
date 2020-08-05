package com.oxygenvideo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oxygenvideo.ui.adapter.MainViewPagerAdapter
import com.example.tablayout.R
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
        }

        //没有类似setUpWithViewPager(vp)的方法, 而是以这种选择item后使vp做出换页的方式
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
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
    }
}