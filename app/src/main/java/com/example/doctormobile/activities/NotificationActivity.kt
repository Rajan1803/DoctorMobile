package com.example.doctormobile.activities

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.doctormobile.R
import com.example.doctormobile.adapters.NotificationAdapter
import com.example.doctormobile.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotificationBinding
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
        val itemDecoration = object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.top = 10
                outRect.bottom = 10
            }
        }
        binding.rvNotification.apply {
            addItemDecoration(itemDecoration)
            layoutManager = LinearLayoutManager(this@NotificationActivity)
            adapter = NotificationAdapter()
        }
    }
}