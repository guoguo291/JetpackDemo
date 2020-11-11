package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.guoj.jetpackdemo.databinding.CoroutineFragmentBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineFragment : Fragment() {

    companion object {
        fun newInstance() = CoroutineFragment()
    }

    private  val viewModel: CoroutineViewModel by viewModels<CoroutineViewModel>()
    private lateinit var binding:CoroutineFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=CoroutineFragmentBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
//            runBlocking {  }//启动协程方式一
//            launch {  }//启动协程方式二
//            async {  }//启动协程方式三
            val job=launch {
                repeat(100){
                    Log.i("hello","协程执行中.."+it)
                    delay(500)
                }
            }

            delay(1500)
            job.cancel()
            Log.i("hello","协程取消")
        }
    }

}