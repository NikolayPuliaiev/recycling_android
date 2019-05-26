package com.nikolaypuliaiev.recycling.utils.BaseClasses

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

open class BaseActivity: AppCompatActivity() {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()
}