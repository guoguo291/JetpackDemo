package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.guoj.jetpackdemo.R
import com.guoj.jetpackdemo.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.live_data_fragment.*

class LiveDataFragment : Fragment() {

    companion object {
        fun newInstance() = LiveDataFragment()
    }
    private val viewModel by viewModels<LiveDataViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.live_data_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()
        initListener()
    }

    private fun initLiveData() {
        viewModel.info.observe(viewLifecycleOwner,Observer<String> {
            tv_livedata.text=it
        })
    }

    private fun initListener() {
        et_livedata.addTextChangedListener {
            text ->viewModel.updataInfo(text.toString())
        }
    }


}