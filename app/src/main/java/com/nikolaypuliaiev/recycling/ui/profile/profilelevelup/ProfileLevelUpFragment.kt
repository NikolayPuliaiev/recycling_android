package com.nikolaypuliaiev.recycling.ui.profile.profilelevelup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentLevelupBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class ProfileLevelUpFragment : BaseFragment() {

    companion object {
        fun newInstance(): ProfileLevelUpFragment = ProfileLevelUpFragment()
    }

    private lateinit var binding: FragmentLevelupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_levelup, container, false)

        binding.fragment = this

        return binding.root
    }
}