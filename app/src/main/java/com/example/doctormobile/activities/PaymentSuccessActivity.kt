package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doctormobile.databinding.ActivityPaymentSuccessBinding

class PaymentSuccessActivity : AppCompatActivity() {
    lateinit var binding: ActivityPaymentSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, DoctorHomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}