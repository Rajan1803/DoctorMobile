package com.example.doctormobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.databinding.RecyclerStatusBinding
import com.example.doctormobile.model.Message

class StatusPagerAdapter : RecyclerView.Adapter<StatusPagerAdapter.StatusHolder>() {
    class StatusHolder(val binding: RecyclerStatusBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.imgStatus.setImageResource(message.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusHolder {
        return StatusHolder(
            RecyclerStatusBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return Message.messages.size
    }

    override fun onBindViewHolder(holder: StatusHolder, position: Int) {
        holder.bind(Message.messages[position])
    }

}