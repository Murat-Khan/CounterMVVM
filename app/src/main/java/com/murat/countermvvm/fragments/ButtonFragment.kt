package com.murat.countermvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.murat.countermvvm.databinding.FragmentButtonBinding
import com.murat.countermvvm.viewmodel.MainViewModel


class ButtonFragment: Fragment() {

    private lateinit var binding: FragmentButtonBinding

    private  val vm : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIncrement.setOnClickListener {
            vm.increment()
        }

        binding.btnDecrement.setOnClickListener {
            vm.decrement()
        }
    }

}