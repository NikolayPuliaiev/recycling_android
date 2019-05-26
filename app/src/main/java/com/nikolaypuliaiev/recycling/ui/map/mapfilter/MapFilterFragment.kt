package com.nikolaypuliaiev.recycling.ui.map.mapfilter

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentMapFilterBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment
import com.nikolaypuliaiev.recycling.utils.DebouncedOnClickListener

class MapFilterFragment : BaseFragment() {

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
        setupObservers()

        return binding.root
    }

    private fun setupUI() {
        binding.backButton.setOnClickListener(object : DebouncedOnClickListener(500) {
            override fun onDebouncedClick(v: View) {
                closeCurrentFragment()
            }
        })

        // Seek bar
        binding.seekBar.setRange(0f, 200f)
        binding.seekBar.setValue(100f)
        binding.seekBar.setIndicatorTextDecimalFormat("0")
        binding.seekBar.setOnRangeChangedListener(object : OnRangeChangedListener {
            override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

            }

            override fun onRangeChanged(view: RangeSeekBar?, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
                if (leftValue == 200f) {
                    view?.setIndicatorText("everywhere")
                } else {
                    view?.setIndicatorText("${leftValue.toInt()} km")
                }
            }

            override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

            }

        })

        // set value for all sorting types
        resetSortingTypes()
    }

    private fun setupObservers() {
        viewModel.glassClicked.observe(this, Observer {
            it?.let {
                binding.glassPressed = !it
            }
        })

        viewModel.batteriesClicked.observe(this, Observer {
            it?.let {
                binding.batteriesPressed = !it
            }
        })

        viewModel.metalClicked.observe(this, Observer {
            it?.let {
                binding.metalPressed = !it
            }
        })

        viewModel.otherClicked.observe(this, Observer {
            it?.let {
                binding.otherPressed = !it
            }
        })

        viewModel.paperClicked.observe(this, Observer {
            it?.let {
                binding.paperPressed = !it
            }
        })

        viewModel.plasticClicked.observe(this, Observer {
            it?.let {
                binding.plasticPressed = !it
            }
        })

        viewModel.tablewareClicked.observe(this, Observer {
            it?.let {
                binding.tablewarePressed = !it
            }
        })

        viewModel.woodClicked.observe(this, Observer {
            it?.let {
                binding.woodPressed = !it
            }
        })

        viewModel.applyClicked.observe(this, Observer {
            closeCurrentFragment()
        })

        viewModel.resetClicked.observe(this, Observer {
            binding.seekBar.setValue(100f)
            resetSortingTypes()
        })
    }

    fun resetSortingTypes() {
        binding.glassPressed = false
        binding.batteriesPressed = false
        binding.metalPressed = false
        binding.otherPressed = false
        binding.paperPressed = false
        binding.plasticPressed = false
        binding.woodPressed = false
        binding.tablewarePressed = false
    }
}