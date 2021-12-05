package com.example.youngstar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youngstar.R
import com.example.youngstar.databinding.ItemHistoryBinding
import com.example.youngstar.databinding.ItemPostBinding

class HistoryRvAdapter : RecyclerView.Adapter<HistoryRvAdapter.VH>() {


    inner class VH(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            binding.apply {
                avatar.setImageResource(R.drawable.avatar3)
                ivHistory.setImageResource(R.drawable.avatar4)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int = 10

}