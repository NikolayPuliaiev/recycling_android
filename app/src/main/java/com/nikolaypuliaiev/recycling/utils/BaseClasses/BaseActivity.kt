package com.nikolaypuliaiev.recycling.utils.BaseClasses

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

open class BaseActivity: AppCompatActivity() {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()
}