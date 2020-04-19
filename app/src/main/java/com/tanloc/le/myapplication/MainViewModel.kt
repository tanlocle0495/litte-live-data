package com.tanloc.le.myapplication

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // create live data when call first
    val data: MutableLiveData<String> by lazy {
        return@lazy MutableLiveData<String>()
    }

    val data2: MutableLiveData<String> by lazy {
        return@lazy MutableLiveData<String>()
    }

//    var mediatorLiveData: MediatorLiveData<String> by lazy {
//        return@lazy MutableLiveData<String>();
//    }

}