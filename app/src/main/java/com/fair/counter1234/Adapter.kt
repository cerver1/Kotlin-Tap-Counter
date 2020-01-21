package com.fair.counter1234

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Increase()
            else -> {Decrease()}

        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> ""
            else -> {""}
        }
    }
}