package com.murat.countermvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.murat.countermvvm.databinding.FragmentCounterBinding
import com.murat.countermvvm.viewmodel.MainViewModel


class CounterFragment: Fragment() {

    private lateinit var binding: FragmentCounterBinding

    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        setupView()
    }

    private fun setupView() {
        viewModel.counterData.observe(viewLifecycleOwner) {
            binding.tvCounter.text = it.toString()

        }
    }

}