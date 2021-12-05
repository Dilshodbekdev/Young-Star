package com.example.youngstar.presentation.service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.youngstar.R
import com.example.youngstar.adapters.DaysRvAdapter
import com.example.youngstar.databinding.FragmentFacilityBinding
import com.example.youngstar.models.Date
import com.example.youngstar.utils.BindingFragment
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper
import kotlin.collections.ArrayList

class FacilityFragment : BindingFragment<FragmentFacilityBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentFacilityBinding::inflate

    private lateinit var adapter: DaysRvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = DaysRvAdapter(generateDatesOfWeek())
            binding.rvAvailabilityDate.adapter = adapter
            OverScrollDecoratorHelper.setUpOverScroll(
                binding.rvAvailabilityDate,
                OverScrollDecoratorHelper.ORIENTATION_HORIZONTAL
            );
        }
    }

    private fun generateDatesOfWeek(): ArrayList<Date> {
        val list = arrayListOf<Date>()
        list.add(Date(0, "Mon", true))
        list.add(Date(1, "Tue", false))
        list.add(Date(2, "Wed", true))
        list.add(Date(3, "Thur", false))
        list.add(Date(4, "Fri", true))
        list.add(Date(5, "Sat", false))
        list.add(Date(6, "Sun", false))
        return list
    }
}