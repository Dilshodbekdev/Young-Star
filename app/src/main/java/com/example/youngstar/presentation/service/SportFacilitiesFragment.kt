package com.example.youngstar.presentation.service

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.youngstar.R
import com.example.youngstar.adapters.SportTowerAdapter
import com.example.youngstar.databinding.FragmentSportFacilitiesBinding
import com.example.youngstar.databinding.ItemTabBinding
import com.example.youngstar.repository.SportRepository
import com.example.youngstar.retrofit.ApiClient
import com.example.youngstar.utils.*
import com.example.youngstar.viewmodels.SportTowerViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SportFacilitiesFragment : BindingFragment<FragmentSportFacilitiesBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentSportFacilitiesBinding::inflate

    private var categoryList =
        listOf("Football", "Boxing", "Kurash", "Suzish", "Tennis", "Karate", "MMA")

    private var categoryListRegion =
        listOf(
            "Tashkent",
            "Samarqand",
            "Navoiy",
            "Sirdaryo",
            "Jizzax",
            "Qashqadaryo",
            "Surxondaryo",
            "Xorazim"
        )

    private lateinit var sportTowerViewModel: SportTowerViewModel
    private lateinit var adapterSportTower: SportTowerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sportTowerViewModel = SportTowerViewModel(
            SportRepository(ApiClient.apiService),
            NetworkHelper(requireContext())
        )

        adapterSportTower = SportTowerAdapter {
            Toast.makeText(requireContext(), "onClick", Toast.LENGTH_SHORT).show()
        }

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, categoryListRegion
        )
        binding.regions.adapter = adapter

        binding.apply {
            rv.adapter = adapterSportTower

            icBack.setOnClickListener {
                findNavController().popBackStack()
            }

            for (category in categoryList) {
                tabLayout.addTab(tabLayout.newTab().setText(category))
            }

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

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val itemTabBinding = ItemTabBinding.bind(tab!!.customView!!)
                    itemTabBinding.card.setCardBackgroundColor(Color.parseColor("#FF475AD7"))
                    itemTabBinding.text.setTextColor(Color.parseColor("#FFFFFFFF"))
                    if (tab.position == 0) {
                        // loadTabData("General")
                    } else {
                        // loadTabData(categoryList[tab.position])
                    }

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val itemTabBinding = ItemTabBinding.bind(tab!!.customView!!)
                    itemTabBinding.card.setCardBackgroundColor(Color.parseColor("#FFF3F4F6"))
                    itemTabBinding.text.setTextColor(Color.parseColor("#FF666C8E"))
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })

            lifecycleScope.launch {
                sportTowerViewModel.fetchSportTowers().collect {
                    when (it) {
                        is DataResource.Loading -> {
                            animationView1.show()
                            Log.d("TAG", "onViewCreated: $it")
                        }
                        is DataResource.Error -> {
                            animationView1.hide()
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                        is DataResource.Success -> {
                            animationView1.hide()
                            Log.d("TAG", "onViewCreated: ${it.list}")
                            adapterSportTower.submitList(it.list)
                        }
                    }
                }
            }
        }

    }

    /*private fun loadTabData(category: String) {
        binding.apply {
            lifecycleScope.launch {
                newsViewModel.getByCategory(category).collect {
                    when (it) {
                        is NewsResource.Loading -> {
                            animationView1.show()
                            tabRv.hide()
                        }
                        is NewsResource.Error -> {
                            animationView1.hide()
                            errorText1.text = it.message
                            errorText1.show()
                        }
                        is NewsResource.Success -> {
                            animationView1.hide()
                            errorText1.hide()
                            tabRv.show()
                            tabRvAdapter.submitList(it.list)
                            tabRv.smoothScrollToPosition(0)
                        }
                    }
                }
            }
        }
    }*/
}