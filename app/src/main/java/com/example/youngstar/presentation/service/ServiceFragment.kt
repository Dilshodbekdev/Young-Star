package com.example.youngstar.presentation.service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.youngstar.R
import com.example.youngstar.databinding.FragmentServiceBinding
import com.example.youngstar.utils.BindingFragment

class ServiceFragment : BindingFragment<FragmentServiceBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentServiceBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            cv1.setOnClickListener {
                findNavController().navigate(R.id.writeTrainingFragment)
            }
            cv2.setOnClickListener {
                findNavController().navigate(R.id.sportFacilitiesFragment)
            }
            cv3.setOnClickListener {
                findNavController().navigate(R.id.levelUpdateFragment)
            }
        }
    }
}