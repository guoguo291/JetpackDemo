package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.guoj.jetpackdemo.R
import kotlinx.android.synthetic.main.lifecycle_fragment.*

class LifecycleFragment : Fragment() {

    companion object {
        fun newInstance() = LifecycleFragment()
    }

    private lateinit var viewModel: LifecycleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lifecycle_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this,SavedStateViewModelFactory(activity?.application!!,this)).get(LifecycleViewModel::class.java)
        mychoronometer.setViewModle(viewModel)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lifecycle.addObserver(mychoronometer)
    }

}