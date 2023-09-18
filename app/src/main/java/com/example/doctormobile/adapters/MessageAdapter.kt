package com.example.doctormobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.R
import com.example.doctormobile.databinding.RecyclerMessageItemBinding
import com.example.doctormobile.model.Message

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageHolder>() {
    class MessageHolder(val binding: RecyclerMessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.message = message
            binding.imgvPicture.setImageResource(message.image)
            if (message.unseenMessages != 0) {
                binding.btnUnreadMsg.apply {
                    visibility = View.VISIBLE
                    text = message.unseenMessages.toString()
                }
                binding.txtvMessage.setTextColor(binding.root.context.getColor(R.color.skyBlue))
            } else {
                binding.btnUnreadMsg.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        return MessageHolder(
            RecyclerMessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return Message.messages.size
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bind(Message.messages[position])
    }
}