package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guoj.jetpackdemo.R
import com.guoj.jetpackdemo.databinding.FragmentTextBinding
import kotlinx.android.synthetic.main.main_content.*

class TextFragment : Fragment() {
    private lateinit var binding:FragmentTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentTextBinding.inflate(inflater, container, false)
        requireActivity().collapsingToolBarLayout.title=getString(R.string.text_fragment_title)
        requireActivity().toolbarIconimageView.setImageResource(R.drawable.ic_looks_one)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tv.text=getString(R.string.placeholder_text)

    }


}