package com.murat.countermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.murat.countermvvm.adapter.ViewPagerAdapter
import com.murat.countermvvm.databinding.ActivityMainBinding
import com.murat.countermvvm.fragments.ButtonFragment
import com.murat.countermvvm.fragments.CounterFragment
import com.murat.countermvvm.fragments.HistoryFragment
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private var fragments = ArrayList<Fragment>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()

    }


    private fun setupViewPager() {
       fragments.add(ButtonFragment())
       fragments.add(CounterFragment())
       fragments.add(HistoryFragment())
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager,fragments)
        binding.viewPager.offscreenPageLimit = 3
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}