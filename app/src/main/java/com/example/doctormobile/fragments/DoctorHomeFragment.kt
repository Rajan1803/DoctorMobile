package com.example.doctormobile.fragments

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.doctormobile.activities.AllDoctorsActivity
import com.example.doctormobile.activities.NotificationActivity
import com.example.doctormobile.adapters.CategoryRVAdapter
import com.example.doctormobile.adapters.DoctorAdapter
import com.example.doctormobile.adapters.PagerAdapter
import com.example.doctormobile.databinding.FragmentDoctorHomeBinding
import com.example.doctormobile.model.Doctor
import com.example.doctormobile.viewmodel.DoctorViewModel
import com.google.android.material.tabs.TabLayoutMediator

class DoctorHomeFragment : Fragment() {

    var allDoctors = ArrayList<Doctor>()
    var doctorAdapter = DoctorAdapter(null)
    var categoryAdapter = CategoryRVAdapter()
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
        activity?.let { activity ->
            val viewModel = ViewModelProvider(activity).get( DoctorViewModel::class.java)
            viewModel.callApi()
            viewModel.hospitalData.observe(activity) { data ->
                binding.viewPager2.adapter = PagerAdapter(data.slider)
                TabLayoutMediator(binding.tablayout, binding.viewPager2) { tab, position ->
                }.attach()

                    categoryAdapter.submitList(category = data.categories)

                data.categories.forEach {
                    allDoctors.addAll(it.doctors)
                }

                    doctorAdapter.submitList(allDoctors)


                Log.d("data", "initViews: $data")
            }
        }

        val categoryItemDecoration = object: ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.apply {
                    right = 20

                }
            }
        }

        binding.rvCategory.addItemDecoration(categoryItemDecoration)
        binding.rvCategory.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)

        binding.rvCategory.adapter = categoryAdapter



        binding.txtvSeeAll.setOnClickListener {
            val intent = Intent(activity, AllDoctorsActivity::class.java)
            intent.putExtra("doctors",allDoctors)
            startActivity(intent)
        }

        binding.viewPager2.adapter = PagerAdapter(null)
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
        binding.rvHomeDoctors.adapter = doctorAdapter

        TabLayoutMediator(binding.tablayout, binding.viewPager2) { tab, position ->
        }.attach()

        binding.imgNotification.setOnClickListener {
            val intent = Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        }

    }

}