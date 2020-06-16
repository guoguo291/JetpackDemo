package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.work.*
import com.guoj.jetpackdemo.databinding.WorkManagerFragmentBinding
import com.guoj.jetpackdemo.work.UploadWorker
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class WorkManagerFragment : Fragment() {

    companion object {
        fun newInstance() = WorkManagerFragment()
    }

    private val viewModel by viewModels<WorkManagerViewModel>()
    private lateinit var binding: WorkManagerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WorkManagerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStartWork.setOnClickListener {
            //添加约束，满足约束条件才开始执行任务
            val constraints = Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .build()
            var workRequest = OneTimeWorkRequestBuilder<UploadWorker>()
                .setInputData(workDataOf("info" to "收到的消息是5号"))
                .setConstraints(constraints)
                .setInitialDelay(300,TimeUnit.MILLISECONDS)//此处有异常,设置时间太长的话等待可能需要很久
                .build()
            val result=WorkManager.getInstance(requireContext()).enqueue(workRequest)
            WorkManager.getInstance(requireContext()).getWorkInfoByIdLiveData(workRequest.id)
                .observe(viewLifecycleOwner, Observer {
                    Log.i("hello","info:"+it.outputData.getString("info"))
                    Log.i("hello","state:"+it.state.name)//工作状态
                    binding.tvInfo.text=it.outputData.getString("info")
                })
        }
    }

}
