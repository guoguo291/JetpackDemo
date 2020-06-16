package com.guoj.jetpackdemo.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * 单向绑定需要给userbean的属性添加@Bindable注解，
 * 并且重写setvalue方法调用notifyChange()或notifyPropertyChanged(BR.name)通知view更新
 */
class User : BaseObservable() {
    @Bindable
    var name: String = ""
        set(value) {
            field = value
//            notifyPropertyChanged(BR.name)
            notifyChange()//通知所有属性更新
        }
    @Bindable
    var age: Int = 0
        set(value) {
            field=value
//            notifyChange()
            notifyPropertyChanged(BR.age)
        }

    override fun toString(): String {
        return "name:"+this.name+"   "+"age:"+this.age
    }
}