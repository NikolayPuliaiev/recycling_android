package com.nikolaypuliaiev.recycling.ui.profile

import androidx.lifecycle.MutableLiveData
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseViewModel

class ProfileViewModel: BaseViewModel() {

    val openEditProfile: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun openEditProfileClick() {
        openEditProfile.value = true
    }

}