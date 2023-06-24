package com.example.doctormobile.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.R
import com.example.doctormobile.databinding.RecyclerDoctorBinding
import com.example.doctormobile.helpers.OnButtonClick
import com.example.doctormobile.model.Doctor

class DoctorAdapter(var visibleData: ArrayList<Doctor>) :
    RecyclerView.Adapter<DoctorAdapter.DoctorHolder>() {
    var delegate: OnButtonClick? = null

    class DoctorHolder(val binding: RecyclerDoctorBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(doctor: Doctor) {
            binding.doctor = doctor
            binding.txtvRatting.text = doctor.ratting.toString()
            binding.imgDoctor.setImageResource(doctor.image)
            if (doctor.isFavourite) binding.imgFavourite.setImageResource(R.drawable.favourited) else binding.imgFavourite.setImageResource(
                R.drawable.favourite
            )


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

        holder.binding.imgFavourite.setOnClickListener {
            Doctor.doctors[holder.adapterPosition].isFavourite =
                !Doctor.doctors[holder.adapterPosition].isFavourite
            notifyItemChanged(holder.adapterPosition)
        }

        holder.binding.btnBook.setOnClickListener {
            delegate?.onBtnSubmitClick(holder.adapterPosition)

        }

        return holder
    }

    override fun getItemCount(): Int {
        return visibleData.size
    }

    override fun onBindViewHolder(holder: DoctorHolder, position: Int) {
        holder.bind(visibleData[position])
    }

}