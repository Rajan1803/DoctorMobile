package com.example.doctormobile.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * setting views
     */
    private fun initViews(){

        binding.cardview.setBackgroundResource(R.drawable.cardview_corner)
        binding.toolbar.toolbarTitle.text = getString(R.string.payment)
        binding.toolbar.toolbarTitle.setTextColor(getColor(R.color.black))
        binding.rgChoosePaymentMode.setOnCheckedChangeListener { p0, currentID ->
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

        binding.btnPayNow.setOnClickListener {
            val intent = Intent(this,PaymentSuccessActivity::class.java)
            startActivity(intent)
        }
    }

}