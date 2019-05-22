package com.nikolaypuliaiev.recycling.utils.BaseClasses

import android.support.annotation.Nullable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ObservableViewModel() {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    /**
     * Implements the cleanup for the networking layer
     *
     * @param disposable the disposable resource to be cleaned up
     * */
    fun executeRequest(@Nullable disposable: Disposable?) {
        disposable?.let {
            compositeDisposable?.add(it)
        }

    }
}