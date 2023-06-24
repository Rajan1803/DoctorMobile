package com.example.doctormobile.activities

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.doctormobile.R
import com.example.doctormobile.adapters.DoctorAdapter
import com.example.doctormobile.databinding.ActivityAllDoctorsBinding
import com.example.doctormobile.helpers.OnButtonClick
import com.example.doctormobile.model.Doctor

class AllDoctorsActivity : AppCompatActivity(), OnButtonClick {
    lateinit var binding: ActivityAllDoctorsBinding
    lateinit var adapter: DoctorAdapter
    lateinit var visibleDoctors: ArrayList<Doctor>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * setting views
     */
    private fun initViews() {

        binding.toolbar.toolbarTitle.text = getString(R.string.all_doctors)
        binding.toolbar.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        visibleDoctors = Doctor.doctors
        binding.rVDoctors.layoutManager = LinearLayoutManager(this)
        adapter = DoctorAdapter(visibleDoctors)
        adapter.delegate = this
        binding.rVDoctors.adapter = adapter
        binding.searchVDoctors.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                visibleDoctors = Doctor.doctors.filter {
                    it.name.lowercase().contains(newText?.lowercase() ?: "")
                } as ArrayList<Doctor>
                adapter.visibleData = visibleDoctors
                adapter.notifyDataSetChanged()
                return false
            }
        })

        /**
         * item decoration for recyclerview
         */
        val itemDecoration = object : ItemDecoration() {
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
        binding.rVDoctors.addItemDecoration(itemDecoration)

    }

    /**
     * on click of submit button from recycler view item
     */
    override fun onBtnSubmitClick(position: Int) {
        val intent = Intent(this, DoctorInfoActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}