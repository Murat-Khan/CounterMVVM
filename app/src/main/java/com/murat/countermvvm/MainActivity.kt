package com.murat.countermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.murat.countermvvm.adapter.ViewPagerAdapter
import com.murat.countermvvm.databinding.ActivityMainBinding
import com.murat.countermvvm.fragments.ButtonFragment
import com.murat.countermvvm.fragments.CounterFragment
import com.murat.countermvvm.fragments.HistoryFragment
import com.murat.countermvvm.viewmodel.MainViewModel
import java.util.ArrayList
class MainActivity : AppCompatActivity() {

    private var fragments = ArrayList<Fragment>()
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()
        setupViewPager()

    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun setupViewPager() {
       fragments.add(ButtonFragment(viewModel))
       fragments.add(CounterFragment(viewModel))
       fragments.add(HistoryFragment(viewModel))
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager,fragments)
        binding.viewPager.offscreenPageLimit = 3
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}