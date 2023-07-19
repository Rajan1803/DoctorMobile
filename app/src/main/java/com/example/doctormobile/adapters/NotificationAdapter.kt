package com.example.doctormobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.databinding.RecyclerNotificationBinding
import com.example.doctormobile.model.Notification

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.NotificationHolder>() {
    class NotificationHolder(val binding: RecyclerNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notification: Notification) {
            binding.notification = notification
            binding.imgNotificationIcon.setImageResource(notification.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationHolder {
        return NotificationHolder(
            RecyclerNotificationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return Notification.notifications.size
    }

    override fun onBindViewHolder(holder: NotificationHolder, position: Int) {
        holder.bind(Notification.notifications[position])
    }
}