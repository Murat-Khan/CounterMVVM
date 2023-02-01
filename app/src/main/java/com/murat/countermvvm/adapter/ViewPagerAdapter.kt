package com.murat.countermvvm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager, private var fragment: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
       return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Кнопки"
            1 -> "Счетчик"
            else -> "История"
        }
    }

}