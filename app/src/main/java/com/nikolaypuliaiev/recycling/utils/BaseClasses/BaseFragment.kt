package com.nikolaypuliaiev.recycling.utils.BaseClasses

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.nikolaypuliaiev.recycling.R
import io.reactivex.disposables.CompositeDisposable

open class BaseFragment: Fragment() {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    /**
     * Closes current fragment with animation
     */
    fun closeCurrentFragment() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.setCustomAnimations(0, R.anim.slide_left)
            ?.remove(this)
            ?.commit()
    }

    /**
     * Closes current fragment without animation
     */
    fun closeCurrentFragmentWithoutAnim() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.remove(this)
            ?.commit()
    }

    fun closeFragmentsStack() {
        // Close all opened fragments in stack
        val fm: FragmentManager
        activity?.let {
            fm = it.supportFragmentManager
            for (i in 0 until fm.backStackEntryCount) {
                fm.popBackStack()
            }
        }
    }
}