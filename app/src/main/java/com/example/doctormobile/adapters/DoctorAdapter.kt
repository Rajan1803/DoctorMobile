package com.example.doctormobile.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctormobile.R
import com.example.doctormobile.databinding.RecyclerDoctorBinding
import com.example.doctormobile.helpers.OnButtonClick
import com.example.doctormobile.model.Doctor

class DoctorAdapter(private var visibleData: List<Doctor>?) :
    RecyclerView.Adapter<DoctorAdapter.DoctorHolder>() {

    var delegate: OnButtonClick? = null
    class DoctorHolder(val binding: RecyclerDoctorBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(doctor: Doctor?) {
            if (doctor != null) {
                binding.doctor = doctor
                Glide.with(binding.root)
                    .load(doctor.image)
                    .into(binding.imgDoctor)
                if (doctor.isSelected) {
                    binding.imgFavourite.setImageResource(R.drawable.favourited)
                } else {
                    binding.imgFavourite.setImageResource(R.drawable.favourite)
                }
                binding.imgFavourite.setOnClickListener {
                    doctor.isSelected = !doctor.isSelected
                    if (doctor.isSelected) {
                        binding.imgFavourite.setImageResource(R.drawable.favourited)
                    } else {
                        binding.imgFavourite.setImageResource(R.drawable.favourite)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorHolder {
        val holder = DoctorHolder(
            RecyclerDoctorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        holder.binding.btnBook.setOnClickListener {
            delegate?.onBtnSubmitClick(visibleData?.get(holder.adapterPosition))
        }
        return holder
    }

    override fun getItemCount(): Int {
        return visibleData?.size ?: 0
    }

    override fun onBindViewHolder(holder: DoctorHolder, position: Int) {
        holder.bind(visibleData?.get(position))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(visibleData: List<Doctor>?) {
        this.visibleData = visibleData
        notifyDataSetChanged()
    }

}