package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guoj.jetpackdemo.R
import kotlinx.android.synthetic.main.main_content.*


class PagerFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().collapsingToolBarLayout.title=getString(R.string.pager_fragment_title)
        return inflater.inflate(R.layout.fragment_pager, container, false)
    }
}