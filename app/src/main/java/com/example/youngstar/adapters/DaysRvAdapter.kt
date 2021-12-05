package com.example.youngstar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youngstar.databinding.ItemDateBinding
import com.example.youngstar.databinding.ItemHistoryBinding
import com.example.youngstar.models.Date

class DaysRvAdapter(private val list: ArrayList<Date>) : RecyclerView.Adapter<DaysRvAdapter.VH>() {

    inner class VH(private val binding: ItemDateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(date: Date) {
            binding.apply {
                tvDay.text = date.day
                tvDayNum.text = date.yest.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemDateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}