package com.nikolaypuliaiev.recycling.ui.profile.profileedit

import androidx.lifecycle.MutableLiveData
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseViewModel

class ProfileEditViewModel : BaseViewModel() {

    val backButtonClick: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun backButtonClicked() {
        backButtonClick.value = true
    }

}