package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivityDoctorInfoBinding
import com.example.doctormobile.model.Doctor

class DoctorInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * setting views
     */
    private fun initViews() {
        binding.toolbar.toolbarTitle.text = getString(R.string.appointment)

        binding.toolbar.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val position = intent.getIntExtra("position", 0)
        binding.doctor = Doctor.doctors[position]
        binding.imgDoc.setImageResource(Doctor.doctors[position].image)
        binding.btnBookAppointment.setOnClickListener {
            val intent = Intent(this,PaymentActivity::class.java)
            startActivity(intent)
        }
    }
}