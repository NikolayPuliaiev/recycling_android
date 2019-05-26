package com.nikolaypuliaiev.recycling.ui.map.mapfilter

import androidx.lifecycle.MutableLiveData
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseViewModel

class MapFilterViewModel : BaseViewModel() {

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

    val applyClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val resetClicked: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun onGlassClick(pressed: Boolean) {
        glassClicked.value = pressed
    }

    fun onPlasticClick(pressed: Boolean) {
        plasticClicked.value = pressed
    }

    fun onPaperClick(pressed: Boolean) {
        paperClicked.value = pressed
    }

    fun onTablewareClick(pressed: Boolean) {
        tablewareClicked.value = pressed
    }

    fun onBatteriesClick(pressed: Boolean) {
        batteriesClicked.value = pressed
    }

    fun onWoodClick(pressed: Boolean) {
        woodClicked.value = pressed
    }

    fun onMetalClick(pressed: Boolean) {
        metalClicked.value = pressed
    }

    fun onOtherClick(pressed: Boolean) {
        otherClicked.value = pressed
    }

    fun onApplyClick() {
        applyClicked.value = true
    }

    fun onResetClick() {
        resetClicked.value = true
    }
}