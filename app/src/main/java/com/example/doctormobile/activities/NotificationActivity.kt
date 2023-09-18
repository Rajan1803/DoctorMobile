package com.example.doctormobile.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctormobile.R
import com.example.doctormobile.adapters.NotificationAdapter
import com.example.doctormobile.databinding.ActivityNotificationBinding
import com.example.doctormobile.helpers.RecyclerDecoration

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    /**
     * setting views
     */
    private fun initViews() {
        binding.toolbar.toolbarTitle.text = getString(R.string.notification)
        binding.toolbar.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.rvNotification.apply {
            addItemDecoration(RecyclerDecoration(top = 10, bottom = 10))
            layoutManager = LinearLayoutManager(this@NotificationActivity)
            adapter = NotificationAdapter()
        }
    }
}