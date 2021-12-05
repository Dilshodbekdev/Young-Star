package com.example.youngstar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youngstar.databinding.ItemSpostFacilitieBinding
import com.example.youngstar.models.sport_tower.Data

class SportTowerAdapter(val onClick: (data: Data) -> Unit) :
    ListAdapter<Data, SportTowerAdapter.VH>(MyDiffUtil()) {

    class MyDiffUtil : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean =
            oldItem == newItem
    }

    inner class VH(private val binding: ItemSpostFacilitieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Data) {
            binding.apply {
                root.setOnClickListener {
                    onClick(data)
                }
                name.text = data.name
                address.text = data.address
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =
            ItemSpostFacilitieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        view.root.layoutParams = ViewGroup.LayoutParams(
            (parent.measuredWidth * 0.65).toInt(),
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }
}