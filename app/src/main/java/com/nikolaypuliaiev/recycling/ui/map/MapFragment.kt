package com.nikolaypuliaiev.recycling.ui.map

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentMapBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class MapFragment: BaseFragment() {

    companion object {
        fun newInstance(): MapFragment = MapFragment()
    }

    // setting up ViewModel
    private val viewModel: MapViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(MapViewModel::class.java)
            }

    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)

        binding.viewModel = viewModel

        return binding.root
    }
}