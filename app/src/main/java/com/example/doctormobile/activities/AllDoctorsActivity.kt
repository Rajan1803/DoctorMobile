package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctormobile.adapters.DoctorAdapter
import com.example.doctormobile.databinding.ActivityAllDoctorsBinding
import com.example.doctormobile.helpers.OnButtonClick
import com.example.doctormobile.helpers.RecyclerDecoration
import com.example.doctormobile.model.Doctor

class AllDoctorsActivity : AppCompatActivity(), OnButtonClick {
    private lateinit var binding: ActivityAllDoctorsBinding
    private lateinit var allDoctors: ArrayList<Doctor>
    private lateinit var adapter: DoctorAdapter
    private lateinit var visibleDoctors: ArrayList<Doctor>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {

        val docs = intent.getParcelableArrayListExtra<Doctor>("doctors")
        allDoctors = docs as ArrayList<Doctor>
        visibleDoctors = allDoctors
        binding.toolbar.toolbarTitle.text = docs.first().type ?: ""
        binding.toolbar.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.rVDoctors.layoutManager = LinearLayoutManager(this)
        adapter = DoctorAdapter(visibleDoctors)
        adapter.delegate = this
        binding.rVDoctors.adapter = adapter
        binding.searchVDoctors.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                visibleDoctors = allDoctors.filter {
                    it.name?.lowercase()?.contains(newText?.lowercase() ?: "") ?: false
                } as ArrayList<Doctor>
                adapter.submitList(visibleDoctors)
                return false
            }
        })
        binding.rVDoctors.addItemDecoration(RecyclerDecoration(top = 30, bottom = 30))
    }

    /**
     * on click of submit button from recycler view item
     */
    override fun onBtnSubmitClick(doctor: Doctor?) {
        val intent = Intent(this, DoctorInfoActivity::class.java)
        intent.putExtra("doctor", doctor)
        startActivity(intent)
    }
}