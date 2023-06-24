package com.example.doctormobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.databinding.PagerLayoutBinding

class PagerAdapter : RecyclerView.Adapter<PagerAdapter.PagerHolder>() {
    class PagerHolder(binding: PagerLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerHolder {
        return PagerHolder(
            PagerLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: PagerHolder, position: Int) {

    }
}