package com.nikolaypuliaiev.recycling.ui.mapfilter

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentMapFilterBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment
import com.nikolaypuliaiev.recycling.utils.DebouncedOnClickListener

class MapFilterFragment: BaseFragment() {

    companion object {
        fun newInstance(): MapFilterFragment = MapFilterFragment()
    }

    // setting up ViewModel
    private val viewModel: MapFilterViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(MapFilterViewModel::class.java)
            }

    private lateinit var binding: FragmentMapFilterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_filter, container, false)

        binding.viewModel = viewModel

        setupUI()

        return binding.root
    }

    private fun setupUI() {
        binding.backButton.setOnClickListener(object: DebouncedOnClickListener(500) {
            override fun onDebouncedClick(v: View) {
                closeCurrentFragment()
            }
        })
    }
}