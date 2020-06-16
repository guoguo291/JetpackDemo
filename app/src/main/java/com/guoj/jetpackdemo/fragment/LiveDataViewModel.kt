package com.guoj.jetpackdemo.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {
    private val _info = MutableLiveData<String>()
    val info:LiveData<String> =_info
    fun updataInfo(info:String){
        _info.postValue(info)
    }
}