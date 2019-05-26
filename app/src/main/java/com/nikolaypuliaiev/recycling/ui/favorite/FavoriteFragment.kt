package com.nikolaypuliaiev.recycling.ui.favorite

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentFavoriteBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class FavoriteFragment: BaseFragment() {

    companion object {
        fun newInstance(): FavoriteFragment = FavoriteFragment()
    }

    // setting up ViewModel
    private val viewModel: FavoriteViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(FavoriteViewModel::class.java)
            }

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)

        binding.viewModel = viewModel

        return binding.root
    }

    private fun setupUI() {
        
    }
}