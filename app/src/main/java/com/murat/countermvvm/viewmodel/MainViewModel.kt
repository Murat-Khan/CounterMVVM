package com.murat.countermvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var operationData = MutableLiveData<String>()

    var counterData = MutableLiveData<Int>()

    var counter = 0


    fun increment()
    {
        counter ++
        counterData.value = counter
        operationData.value = "+"
    }

    fun decrement()
    {
        counter --
        counterData.value = counter
        operationData.value = "-"
    }

}