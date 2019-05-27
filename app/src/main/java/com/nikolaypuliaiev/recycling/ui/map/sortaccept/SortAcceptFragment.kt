package com.nikolaypuliaiev.recycling.ui.map.sortaccept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.list.listItems
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentSortAcceptBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment

class SortAcceptFragment: BaseFragment() {

    companion object {
        fun newInstance(): SortAcceptFragment = SortAcceptFragment()
    }

    // setting up ViewModel
    private val viewModel: SortAcceptViewModel
            by lazy {
                ViewModelProviders.of(this)
                    .get(SortAcceptViewModel::class.java)
            }

    private lateinit var binding: FragmentSortAcceptBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sort_accept, container, false)

        binding.viewModel = viewModel

        setupUI()

        return binding.root
    }

    private fun setupUI() {

        binding.chooseButton.setOnClickListener {
            this.context?.let {
                MaterialDialog(it, BottomSheet(LayoutMode.WRAP_CONTENT)).show {
                    listItems(R.array.sample) { dialog, index, text ->

                    }

                    positiveButton(R.string.accept)
                    negativeButton(R.string.cancel)

                    cornerRadius(9f)
                }
            }
        }

        binding.weightUnitButton.setOnClickListener {
            this.context?.let {
                MaterialDialog(it, BottomSheet(LayoutMode.WRAP_CONTENT)).show {
                    listItems(R.array.weight_unit) { dialog, index, text ->

                    }

                    positiveButton(R.string.accept)
                    negativeButton(R.string.cancel)

                    cornerRadius(9f)
                }
            }
        }

        binding.backButton.setOnClickListener {
            closeCurrentFragment()
        }

        binding.nextButton.setOnClickListener {
            fragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.slide_right, 0, 0, R.anim.slide_left)
                ?.add(R.id.base_container, QRCodeSortFragment.newInstance())
                ?.addToBackStack("qr_code_sort")
                ?.commit()
        }
    }

}