package com.murat.countermvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel

import com.murat.countermvvm.databinding.FragmentButtonBinding
import com.murat.countermvvm.viewmodel.MainViewModel


class ButtonFragment(private var vm : MainViewModel) : Fragment() {

    private lateinit var binding: FragmentButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()
    }

    private fun initClicker() {
        binding.btnIncrement.setOnClickListener {
            vm.increment()
        }

        binding.btnDecrement.setOnClickListener {
            vm.decrement()
        }
    }

}