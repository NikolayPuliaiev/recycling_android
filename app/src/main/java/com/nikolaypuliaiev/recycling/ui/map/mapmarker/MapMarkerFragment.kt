package com.nikolaypuliaiev.recycling.ui.map.mapmarker

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentMapMarkerBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class MapMarkerFragment: BaseFragment() {

    companion object {
        fun newInstance(): MapMarkerFragment = MapMarkerFragment()
    }

    // setting up ViewModel
    private val viewModel: MapMarkerViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(MapMarkerViewModel::class.java)
            }

    private lateinit var binding: FragmentMapMarkerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_marker, container, false)

        binding.viewModel = viewModel

        setupUI()

        return binding.root
    }

    private fun setupUI() {
        binding.outerLayout.setOnClickListener {
            closeCurrentFragmentWithoutAnim()
        }
    }
}