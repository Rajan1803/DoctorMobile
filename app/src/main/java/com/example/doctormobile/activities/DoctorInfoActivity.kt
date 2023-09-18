package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivityDoctorInfoBinding
import com.example.doctormobile.model.Doctor

class DoctorInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorInfoBinding
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

        val doctor = intent.getParcelableExtra<Doctor>("doctor")
        binding.doctor = doctor
        Glide.with(binding.root)
            .load(doctor?.image)
            .into(binding.imgDoc)
        binding.btnBookAppointment.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
    }
}