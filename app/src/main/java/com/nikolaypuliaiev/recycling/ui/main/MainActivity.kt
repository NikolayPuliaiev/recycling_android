package com.nikolaypuliaiev.recycling.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.ActivityMainBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseActivity

class MainActivity : BaseActivity() {

    private val homeViewModel: MainViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(MainViewModel::class.java)
            }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting up bindings
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = homeViewModel


    }
}
