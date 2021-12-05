package com.example.youngstar.presentation.service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.youngstar.R
import com.example.youngstar.databinding.FragmentLevelUpdateBinding
import com.example.youngstar.utils.BindingFragment

class LevelUpdateFragment : BindingFragment<FragmentLevelUpdateBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentLevelUpdateBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}