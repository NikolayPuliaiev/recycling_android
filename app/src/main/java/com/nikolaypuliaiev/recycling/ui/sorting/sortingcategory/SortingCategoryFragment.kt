package com.nikolaypuliaiev.recycling.ui.sorting.sortingcategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.ui.sorting.sortingresult.SortingResultFragment
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class SortingCategoryFragment : BaseFragment() {

    companion object {
        fun newInstance(): SortingCategoryFragment = SortingCategoryFragment()
    }

    // setting up ViewModel
    private val viewModel: SortingCategoryViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(SortingCategoryViewModel::class.java)
            }

    private lateinit var binding: com.nikolaypuliaiev.recycling.databinding.FragmentSortingCategoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sorting_category, container, false)

        binding.viewModel = viewModel

        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.openKind.observe(this, Observer {
            fragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.slide_right, 0, 0, R.anim.slide_left)
                ?.add(R.id.base_container, SortingResultFragment.newInstance())
                ?.addToBackStack("sorting_result")
                ?.commit()
        })

        viewModel.backButton.observe(this, Observer {
            closeCurrentFragment()
        })
    }
}