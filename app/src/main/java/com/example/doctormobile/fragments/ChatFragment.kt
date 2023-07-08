package com.example.doctormobile.fragments

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.doctormobile.adapters.MessageAdapter
import com.example.doctormobile.adapters.StatusPagerAdapter
import com.example.doctormobile.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    lateinit var binding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChatBinding.inflate(layoutInflater)
        initViews()
        return binding.root
    }

    /**
     * setting Views
     */
    private fun initViews() {
        val itemDecoration = object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    left = 10
                    right = 10
                }
            }
        }

        val itemDecorationMessage = object: ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    top = 16
                    bottom = 16
                }
            }
        }

        binding.rvStatus.addItemDecoration(itemDecoration)
        binding.rvStatus.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.rvStatus.adapter = StatusPagerAdapter()

        binding.rvMessages.layoutManager = LinearLayoutManager(activity)
        binding.rvMessages.addItemDecoration(itemDecorationMessage)
        binding.rvMessages.adapter = MessageAdapter()
    }

}