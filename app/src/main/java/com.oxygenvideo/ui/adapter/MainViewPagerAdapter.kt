package com.oxygenvideo.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.oxygenvideo.ui.fragment.ChildFragment
import com.oxygenvideo.ui.fragment.MessageFragment

class MainViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_SET_USER_VISIBLE_HINT)
{
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ChildFragment.newInstance("HOME")
            1 -> MessageFragment()
            else -> ChildFragment.newInstance("PERSON")
        }
    }
    override fun getCount(): Int = 3

}