package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.guoj.jetpackdemo.R
import kotlinx.android.synthetic.main.lifecycle_fragment.*

class LifecycleFragment : Fragment() {

    companion object {
        fun newInstance() = LifecycleFragment()
    }

    private val viewModel: LifecycleViewModel by viewModels<LifecycleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lifecycle_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mychoronometer.setViewModle(viewModel)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lifecycle.addObserver(mychoronometer)
    }

}