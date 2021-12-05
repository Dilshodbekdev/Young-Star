package com.example.youngstar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youngstar.databinding.ItemPostBinding

class PostRvAdapter : RecyclerView.Adapter<PostRvAdapter.VH>() {


    inner class VH(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(name: String, position: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

    }

    override fun getItemCount(): Int = 10

}