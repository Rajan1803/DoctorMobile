package com.example.doctormobile.fragments

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.activities.AllDoctorsActivity
import com.example.doctormobile.activities.NotificationActivity
import com.example.doctormobile.adapters.DoctorAdapter
import com.example.doctormobile.adapters.PagerAdapter
import com.example.doctormobile.databinding.FragmentDoctorHomeBinding
import com.example.doctormobile.model.Doctor
import com.google.android.material.tabs.TabLayoutMediator

class DoctorHomeFragment : Fragment() {

    lateinit var binding: FragmentDoctorHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoctorHomeBinding.inflate(layoutInflater)
        initViews()
        return binding.root
    }

    /**
     * setting Views
     */
    fun initViews() {
        binding.txtvSeeAll.setOnClickListener {
            val intent = Intent(activity, AllDoctorsActivity::class.java)
            startActivity(intent)
        }


        binding.viewPager2.adapter = PagerAdapter()
        binding.rvHomeDoctors.layoutManager = LinearLayoutManager(activity)

        val itemDecoration = object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    top = 30
                    bottom = 30
                }
            }
        }
        binding.rvHomeDoctors.addItemDecoration(itemDecoration)
        binding.rvHomeDoctors.adapter = DoctorAdapter(Doctor.doctors)

        TabLayoutMediator(binding.tablayout, binding.viewPager2) { tab, position ->
        }.attach()

        binding.imgNotification.setOnClickListener {
            val intent = Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

}