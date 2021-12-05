package com.example.youngstar.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.example.youngstar.R
import com.example.youngstar.databinding.FragmentMainBinding
import com.example.youngstar.utils.BindingFragment

class MainFragment : BindingFragment<FragmentMainBinding>() {


    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentMainBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      /*  val adapter = ViewPagerAdapter(
            listOf(HomeFragment(), NewsFragment(), EducationsFragment(), ProfileFragment()),
            childFragmentManager,
            lifecycle
        )

        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = adapter

        binding.bottomBar.setOnItemSelectedListener {
            binding.viewPager.currentItem = it
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomBar.itemActiveIndex = position
            }
        })*/
    }
}