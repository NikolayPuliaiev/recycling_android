package com.nikolaypuliaiev.recycling.ui.profile.profileedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentProfileEditBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class ProfileEditFragment : BaseFragment() {

    companion object {
        fun newInstance(): ProfileEditFragment = ProfileEditFragment()
    }

    // setting up ViewModel
    private val viewModel: ProfileEditViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(ProfileEditViewModel::class.java)
            }

    private lateinit var binding: FragmentProfileEditBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_edit, container, false)

        binding.viewModel = viewModel

        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.backButtonClick.observe(this, Observer {
            closeCurrentFragment()
        })
    }
}