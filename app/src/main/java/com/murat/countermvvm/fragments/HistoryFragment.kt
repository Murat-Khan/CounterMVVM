package com.murat.countermvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.murat.countermvvm.databinding.FragmentHistoryBinding
import com.murat.countermvvm.viewmodel.MainViewModel


class HistoryFragment(private var vm: MainViewModel) : Fragment() {

    private lateinit var bindimg: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindimg = FragmentHistoryBinding.inflate(inflater, container, false)
        return bindimg.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.operationData.observe(requireActivity()) {

            bindimg.tvHistory.append("\n${it.toString()}")

        }
    }
}