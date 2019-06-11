package com.nikolaypuliaiev.recycling.ui.sorting

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentSortingBinding
import com.nikolaypuliaiev.recycling.ui.sorting.sortingcategory.SortingCategoryFragment
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class SortingFragment: BaseFragment() {

    companion object {
        fun newInstance(): SortingFragment = SortingFragment()
    }

    // setting up ViewModel
    private val viewModel: SortingViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(SortingViewModel::class.java)
            }

    private lateinit var binding: FragmentSortingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sorting, container, false)

        binding.viewModel = viewModel

        setupObservers()

        return binding.root
    }

    fun setupObservers() {
        viewModel.glassClicked.observe(this, Observer {
            fragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.slide_right, 0, 0, R.anim.slide_left)
                ?.add(R.id.base_container, SortingCategoryFragment.newInstance())
                ?.addToBackStack("sorting_category")
                ?.commit()
        })

        viewModel.batteriesClicked.observe(this, Observer {

        })

        viewModel.metalClicked.observe(this, Observer {

        })

        viewModel.otherClicked.observe(this, Observer {

        })

        viewModel.paperClicked.observe(this, Observer {

        })

        viewModel.plasticClicked.observe(this, Observer {

        })

        viewModel.tablewareClicked.observe(this, Observer {

        })

        viewModel.woodClicked.observe(this, Observer {

        })
    }
}