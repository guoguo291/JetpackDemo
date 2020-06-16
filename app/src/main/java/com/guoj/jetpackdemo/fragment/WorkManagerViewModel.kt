package com.guoj.jetpackdemo.fragment

import androidx.lifecycle.ViewModel

class WorkManagerViewModel private constructor(): ViewModel() {
   companion object{
       val instance=InstanceHolder.instance
   }
    private object InstanceHolder{
        val instance=WorkManagerViewModel()
    }
}
