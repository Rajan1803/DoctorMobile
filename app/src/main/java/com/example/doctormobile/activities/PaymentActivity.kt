package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {

        binding.apply {
            cardview.setBackgroundResource(R.drawable.cardview_corner)
            toolbar.toolbarTitle.text = getString(R.string.payment)
            toolbar.toolbarTitle.setTextColor(getColor(R.color.black))
        }
        binding.rgChoosePaymentMode.setOnCheckedChangeListener { _, currentID ->
            when (currentID) {
                binding.btnCardPayment.id -> {
                    binding.group.visibility = View.VISIBLE
                    binding.btnPayNow.text = getString(R.string.pay_now)
                }

                binding.btnCashPayment.id -> {
                    binding.group.visibility = View.INVISIBLE
                    binding.btnPayNow.text = getString(R.string.place_order)
                }
            }
        }
        binding.toolbar.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.btnPayNow.setOnClickListener {
            val intent = Intent(this, PaymentSuccessActivity::class.java)
            startActivity(intent)
        }
    }

}