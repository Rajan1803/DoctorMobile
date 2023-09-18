package com.example.doctormobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.R
import com.example.doctormobile.databinding.RecyclerProfileBinding
import com.example.doctormobile.model.ProfileItem

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileHolder>() {
    class ProfileHolder(val binding: RecyclerProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProfileItem) {
            binding.txtvProfileOptions.text = item.title
            binding.imgLogo.setImageResource(item.logo)
            if (item.title == binding.root.context.getString(R.string.logout)) {
                binding.imgArrow.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        return ProfileHolder(
            RecyclerProfileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return ProfileItem.items.size
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.bind(ProfileItem.items[position])
    }
}