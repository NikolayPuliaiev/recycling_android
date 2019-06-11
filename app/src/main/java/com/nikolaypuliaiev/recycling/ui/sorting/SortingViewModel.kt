package com.nikolaypuliaiev.recycling.ui.sorting

import androidx.lifecycle.MutableLiveData
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseViewModel

class SortingViewModel: BaseViewModel() {

    val glassClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val plasticClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val paperClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val tablewareClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val batteriesClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val woodClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val metalClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val otherClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun onGlassClick() {
        glassClicked.value = true
    }

    fun onPlasticClick() {
        plasticClicked.value = true
    }

    fun onPaperClick() {
        paperClicked.value = true
    }

    fun onTablewareClick() {
        tablewareClicked.value = true
    }

    fun onBatteriesClick() {
        batteriesClicked.value = true
    }

    fun onWoodClick() {
        woodClicked.value = true
    }

    fun onMetalClick() {
        metalClicked.value = true
    }

    fun onOtherClick() {
        otherClicked.value = true
    }

}