package com.nikolaypuliaiev.recycling.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.ActivityMainBinding
import com.nikolaypuliaiev.recycling.ui.favorite.FavoriteFragment
import com.nikolaypuliaiev.recycling.ui.map.MapFragment
import com.nikolaypuliaiev.recycling.ui.profile.ProfileFragment
import com.nikolaypuliaiev.recycling.ui.sorting.SortingFragment
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

        // Open first tab
        openFragment(MapFragment.newInstance())

        setupObservers()
    }

    private fun setupObservers() {
        binding.navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_map -> {
                    openFragment(MapFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_sorting -> {
                    openFragment(SortingFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    openFragment(ProfileFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_favorite -> {
                    openFragment(FavoriteFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }

        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
