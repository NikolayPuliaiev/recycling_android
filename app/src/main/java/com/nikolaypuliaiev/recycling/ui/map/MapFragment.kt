package com.nikolaypuliaiev.recycling.ui.map

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentMapBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment


class MapFragment : BaseFragment() {

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

        setupUI()

        // Initialize Google Maps

        binding.map.onCreate(savedInstanceState)
        binding.map.onResume()  // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(this.context)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.map.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.map.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.map.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.map.onLowMemory()
    }

    private fun setupUI() {
        binding.map.getMapAsync { map ->
            // For dropping a marker at a point on the Map
            val sydney = LatLng(-34.0, 151.0)
            map.addMarker(MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"))

            // For zooming automatically to the location of the marker
            val cameraPosition = CameraPosition.Builder().target(sydney).zoom(12f).build()
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }
}