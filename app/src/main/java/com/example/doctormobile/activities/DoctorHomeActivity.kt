package com.example.doctormobile.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivityDoctorHomeBinding
import com.example.doctormobile.fragments.ChatFragment
import com.example.doctormobile.fragments.DoctorHomeFragment
import com.example.doctormobile.fragments.ProfileFragment
import com.example.doctormobile.fragments.TimingFragment

class DoctorHomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityDoctorHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * setting views
     */
    private fun initViews() {
        binding.bottonNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(DoctorHomeFragment())
                    binding.toolbar.toolbar.visibility = View.GONE
                }

                R.id.time -> {
                    loadFragment(TimingFragment())
                }

                R.id.chat -> {

                    loadFragment(ChatFragment())
                    binding.toolbar.apply {
                        toolbar.visibility = View.VISIBLE
                        imgBack.visibility = View.GONE
                        toolbarTitle.text = getString(R.string.message)
                    }
                }

                R.id.profile -> {

                    loadFragment(ProfileFragment())
                    binding.toolbar.apply {
                        toolbar.visibility = View.VISIBLE
                        imgBack.visibility = View.GONE
                        toolbarTitle.text = getString(R.string.profile)
                    }
                }
            }
            true
        }
        loadFragment(DoctorHomeFragment())
    }

    /**
     * function for loading fragment
     */
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}