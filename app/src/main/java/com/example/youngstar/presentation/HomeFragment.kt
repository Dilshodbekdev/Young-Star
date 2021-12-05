package com.example.youngstar.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.youngstar.adapters.HistoryRvAdapter
import com.example.youngstar.adapters.PostRvAdapter
import com.example.youngstar.databinding.FragmentHomeBinding
import com.example.youngstar.utils.BindingFragment


class HomeFragment : BindingFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentHomeBinding::inflate

    private lateinit var adapterPost: PostRvAdapter
    private lateinit var adapterHistory: HistoryRvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapterPost = PostRvAdapter()
            adapterHistory = HistoryRvAdapter()
            rvPost.adapter = adapterPost
            rvHistory.adapter = adapterHistory
        }
    }
}