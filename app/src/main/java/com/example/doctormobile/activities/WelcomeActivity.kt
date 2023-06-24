package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.widget.addTextChangedListener
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivityWelcomeBinding
import com.example.doctormobile.helpers.Utility

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * setting views
     */
    private fun initViews() {
        binding.toolbar.toolbarTitle.text = getString(R.string.welcome)
        binding.toolbar.imgBack.visibility = View.GONE

        binding.etxtEmail.addTextChangedListener {
            if (!Utility.isEmailValid(binding.etxtEmail.text.toString())) {
                binding.txtinputLayoutEmail.error = getString(R.string.invalidEmailMessage)
            } else {
                binding.txtinputLayoutEmail.error = null
            }
        }

        binding.etxtPassword.addTextChangedListener { pass ->
            if (!Utility.isValidPassword(pass.toString())) {
                binding.txtinputLayout.error = getString(R.string.weakPasswordMessage)
            } else {
                binding.txtinputLayout.error = null
            }
        }

        binding.btnSignIn.setOnClickListener {
            if (!allFieldsValid()) {
                Toast.makeText(this, getString(R.string.fillAllFields), Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DoctorHomeActivity::class.java)
                startActivity(intent)
            }
        }

        binding.txtvAlreadyAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

     /**
     * checking if all fields are properly filed
     */
    private fun allFieldsValid(): Boolean {
        return (binding.txtinputLayout.error == null && binding.txtinputLayoutEmail.error == null && binding.etxtEmail.text?.isNotEmpty() ?: false && binding.etxtPassword.text?.isNotEmpty() ?: false)
    }
}