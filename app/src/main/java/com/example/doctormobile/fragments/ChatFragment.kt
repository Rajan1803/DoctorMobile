package com.example.doctormobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctormobile.adapters.MessageAdapter
import com.example.doctormobile.adapters.StatusPagerAdapter
import com.example.doctormobile.databinding.FragmentChatBinding
import com.example.doctormobile.helpers.RecyclerDecoration


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(layoutInflater)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.rvStatus.apply {
            addItemDecoration(RecyclerDecoration(left = 10, right = 10))
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = StatusPagerAdapter()
        }
        binding.rvMessages.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(RecyclerDecoration(top = 16, bottom = 16))
            adapter = MessageAdapter()
        }
    }
}