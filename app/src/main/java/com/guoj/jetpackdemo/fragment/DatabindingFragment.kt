package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.guoj.jetpackdemo.R
import com.guoj.jetpackdemo.bean.User
import com.guoj.jetpackdemo.databinding.DBbinding

/**
 * Databinding:使用需要考虑的问题：
 * 1.低版本机器中不建议使用，自动生成的类较多，同一个界面占用内存较大
 * 2.序列化实现了BaseObservable的Bean类的时可能存在问题
 */
class DatabindingFragment : Fragment() {
    private lateinit var binding: DBbinding
    private lateinit var user: User
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_databinding, container, false)
        user = User()
        binding.user = user
//        binding.setVariable(BR.user,user)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvUserinfo.text = user.toString()
        binding.btnUpdateAge.setOnClickListener { user.age += 1 }
        binding.btnUpdateName.setOnClickListener {
            Log.i("hello", "onViewCreated: " + user.name)
            user.name = "guoj"
        }

    }

    public class ListenerBinding() {
        fun onAddBtnClick() {

        }
    }
}