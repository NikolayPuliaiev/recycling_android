package com.nikolaypuliaiev.recycling.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.ActivityMainBinding
import com.nikolaypuliaiev.recycling.ui.favorite.FavoriteFragment
import com.nikolaypuliaiev.recycling.ui.map.MapFragment
import com.nikolaypuliaiev.recycling.ui.mapfilter.MapFilterFragment
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

    var fragmentInstance = FragmentInstance.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting up bindings
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = homeViewModel

        // Open first tab
        openFragment(MapFragment.newInstance())
        fragmentInstance = FragmentInstance.MAP

        setupObservers()
    }

    private fun setupObservers() {
        binding.navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_map -> {
                    if (fragmentInstance != FragmentInstance.MAP) {
                        openFragment(MapFragment.newInstance())
                        fragmentInstance = FragmentInstance.MAP
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_sorting -> {
                    if (fragmentInstance != FragmentInstance.SORTING) {
                        openFragment(SortingFragment.newInstance())
                        fragmentInstance = FragmentInstance.SORTING
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    if (fragmentInstance != FragmentInstance.PROFILE) {
                        openFragment(ProfileFragment.newInstance())
                        fragmentInstance = FragmentInstance.PROFILE
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_favorite -> {
                    if (fragmentInstance != FragmentInstance.FAVORITE) {
                        openFragment(FavoriteFragment.newInstance())
                        fragmentInstance = FragmentInstance.FAVORITE
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    fragmentInstance = FragmentInstance.NONE
                    false
                }
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

    fun openFilterScreen() {
        supportFragmentManager
            ?.beginTransaction()
            ?.setCustomAnimations(0, R.anim.slide_up)
            ?.replace(R.id.base_container, MapFilterFragment.newInstance())
            ?.addToBackStack("map_filter")
            ?.commit()
    }
}

enum class FragmentInstance {
    MAP, SORTING, PROFILE, FAVORITE, NONE
}
