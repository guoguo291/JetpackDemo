package com.guoj.jetpackdemo.fragment

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LifecycleViewModel() : ViewModel() {
//    var elapsedTime:Long=0
    lateinit var handle:SavedStateHandle
    constructor(savedStateHandle:SavedStateHandle):this(){
        this.handle=savedStateHandle
    }
    fun getMyElapsedTime():Long{
        if (!handle.contains("time")){
            handle.set("time",0L)
        }
        return handle.get<Long>("time")!!
    }
    fun setMyElapsedTime(time:Long){
       handle.set("time",time)
    }
}