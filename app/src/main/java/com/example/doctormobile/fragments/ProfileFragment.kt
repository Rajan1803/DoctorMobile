package com.example.doctormobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctormobile.adapters.ProfileAdapter
import com.example.doctormobile.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater)

        initViews()

        return binding.root
    }

    /**
     * setting Views
     */
    private fun initViews() {
        binding.rvProfileItems.layoutManager = LinearLayoutManager(activity)
        binding.rvProfileItems.adapter = ProfileAdapter()
    }


}