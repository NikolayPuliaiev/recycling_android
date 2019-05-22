package com.nikolaypuliaiev.recycling.ui.sorting

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentSortingBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class SortingFragment: BaseFragment() {

    companion object {
        fun newInstance(): SortingFragment = SortingFragment()
    }

    // setting up ViewModel
    private val viewModel: SortingViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(SortingViewModel::class.java)
            }

    private lateinit var binding: FragmentSortingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sorting, container, false)

        binding.viewModel = viewModel

        return binding.root
    }
}