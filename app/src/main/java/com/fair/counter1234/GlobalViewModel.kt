package com.fair.counter1234

import android.app.Application
import android.content.Context
import android.support.v4.app.INotificationSideChannel
import android.view.View
import androidx.lifecycle.*

class GlobalViewModel: ViewModel() {

    var _incremental = MutableLiveData<Int>()
    val incremental : LiveData<Int>
        get() = _incremental


    var _decremental = MutableLiveData<Int>()
    val decremental : LiveData<Int>
            get() = _decremental

    fun incrementOnClick() {
        _incremental.value = _incremental.value?.plus(1)
//        initialIncrease++
//        txtIncreasing.text = initialIncrease.toString()
//        fabResetIncreasing.visibility = View.VISIBLE
    }

    fun decrementOnClick() {
        _decremental.value = _decremental.value?.minus(1)
//        val validation = txtDecreasing.text.toString()
//        txtDecreasing.text = (validation.toInt() - 1).toString()
//        fabResetDecreasing.setImageResource(R.drawable.reset)
    }

}