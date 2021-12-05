package com.example.youngstar.presentation.service

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.youngstar.R
import com.example.youngstar.databinding.FragmentSportFacilitiesBinding
import com.example.youngstar.databinding.ItemTabBinding
import com.example.youngstar.utils.BindingFragment

class SportFacilitiesFragment : BindingFragment<FragmentSportFacilitiesBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentSportFacilitiesBinding::inflate

    private var categoryList =
        listOf("Football", "Boxing", "Kurash", "Suzish", "Tennis", "Karate", "MMA")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            categoryList.forEachIndexed { index, s ->
                val tabBinding = ItemTabBinding.inflate(layoutInflater)
                tabBinding.text.text = s
                if (index == 0) {
                    tabBinding.card.setCardBackgroundColor(Color.parseColor("#FF475AD7"))
                    tabBinding.text.setTextColor(Color.parseColor("#FFFFFFFF"))
                } else {
                    tabBinding.card.setCardBackgroundColor(Color.parseColor("#FFF3F4F6"))
                    tabBinding.text.setTextColor(Color.parseColor("#FF666C8E"))
                }
                tabLayout.getTabAt(index)?.customView = tabBinding.root
            }
        }
    }
}