package com.nikolaypuliaiev.recycling.ui.sorting.sortingcategory

import androidx.lifecycle.MutableLiveData
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseViewModel

class SortingCategoryViewModel : BaseViewModel() {

    val openKind: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val backButton: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun openKindClick() {
        openKind.value = true
    }

    fun backButtonClick() {
        backButton.value = true
    }

}