package com.example.doctormobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctormobile.databinding.PagerLayoutBinding
import com.example.doctormobile.model.Slider

class PagerAdapter(val sliders: List<Slider>?) : RecyclerView.Adapter<PagerAdapter.PagerHolder>() {
    class PagerHolder(val binding: PagerLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(slider: Slider?) {
            binding.slider = slider
            Glide.with(binding.root)
                .load(slider?.image)
                .into(binding.imgDoctorPager)
        }
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
        return sliders?.size ?: 0
    }

    override fun onBindViewHolder(holder: PagerHolder, position: Int) {
        holder.bind(sliders?.get(position))
    }
}