package com.guoj.jetpackdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.guoj.jetpackdemo.R
import com.guoj.jetpackdemo.databinding.FragmentJetpackBinding
import kotlinx.android.synthetic.main.main_content.*


class JetpackFragment : Fragment() {
    private lateinit var binding:FragmentJetpackBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController=findNavController()
        requireActivity().collapsingToolBarLayout.title=getString(R.string.jetpack_fragment_title)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentJetpackBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnWorkmanager.setOnClickListener{
                navController.navigate(R.id.action_homeFragment_to_workManagerFragment)
            }
            btnDatabinding.setOnClickListener {
                navController.navigate(R.id.action_jetpackFragment_to_databindingFragment)
            }
            btnLivedata.setOnClickListener {
                navController.navigate(R.id.action_jetpackFragment_to_liveDataFragment)
            }

        }
    }

}
