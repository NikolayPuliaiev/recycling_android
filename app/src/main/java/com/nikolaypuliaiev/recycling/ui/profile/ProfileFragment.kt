package com.nikolaypuliaiev.recycling.ui.profile

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentProfileBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class ProfileFragment : BaseFragment() {

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }

    // setting up ViewModel
    private val viewModel: ProfileViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(ProfileViewModel::class.java)
            }

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.viewModel = viewModel

        return binding.root
    }
}