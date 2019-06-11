package com.nikolaypuliaiev.recycling.ui.sorting.sortingresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentSortingResultBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class SortingResultFragment : BaseFragment() {

    companion object {
        fun newInstance(): SortingResultFragment = SortingResultFragment()
    }

    private lateinit var binding: FragmentSortingResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sorting_result, container, false)

        binding.fragment = this

        return binding.root
    }

    fun backClicked() {
        closeCurrentFragment()
    }
}