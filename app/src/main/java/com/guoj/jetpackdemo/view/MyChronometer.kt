package com.guoj.jetpackdemo.view

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.guoj.jetpackdemo.fragment.LifecycleViewModel

class MyChronometer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Chronometer(context, attrs, defStyleAttr),LifecycleObserver {
    //    constructor(context:Context):this(context,null)
    //    constructor(context:Context,attrs:AttributeSet?):this(context,attrs,0)
    //    constructor(context:Context,attrs:AttributeSet?,defStyleAttr:Int):super(context,attrs,defStyleAttr)
     var elapsedTime:Long=0
    lateinit var viewModel:LifecycleViewModel
    fun setViewModle(viewModel:LifecycleViewModel){
        this.viewModel=viewModel
        this.elapsedTime=viewModel.getMyElapsedTime()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun startMeter() {
        base=SystemClock.elapsedRealtime()-elapsedTime
        start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun pauseMeter() {
        elapsedTime = SystemClock.elapsedRealtime()-base
        viewModel.setMyElapsedTime(elapsedTime)
        stop()
    }
}
