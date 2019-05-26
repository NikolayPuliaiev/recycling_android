package com.nikolaypuliaiev.recycling.ui.map

import androidx.lifecycle.MutableLiveData
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseViewModel

class MapViewModel: BaseViewModel() {

    val filterButtonClick: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun onFilterClick() {
        filterButtonClick.value = true
    }
}