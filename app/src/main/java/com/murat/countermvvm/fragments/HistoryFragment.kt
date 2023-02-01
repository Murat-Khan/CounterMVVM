package com.murat.countermvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.murat.countermvvm.databinding.FragmentHistoryBinding
import com.murat.countermvvm.viewmodel.MainViewModel


class HistoryFragment: Fragment() {

    private  val vm : MainViewModel by activityViewModels()
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.operationData.observe(requireActivity()) {

            binding.tvHistory.append("\n${it.toString()}")

        }
    }
}