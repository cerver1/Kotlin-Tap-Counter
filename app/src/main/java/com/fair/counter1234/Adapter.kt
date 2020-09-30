package com.fair.counter1234

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = 2

    override fun getItem(position: Int) =
        when (position) {
            0 -> Increase()
            else -> Decrease()
        }

    override fun getPageTitle(position: Int) =
        when (position) {
            0 -> ""
            else -> ""
        }
}