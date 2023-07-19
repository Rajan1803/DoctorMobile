package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivitySignUpBinding
import com.example.doctormobile.helpers.Utility

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.toolbar.apply {
            toolbarTitle.text = getString(R.string.create_new_account)
            imgBack.visibility = View.GONE
        }
        binding.txtvToSignIn.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
        binding.etxtPassword.addTextChangedListener { password ->
            if (!Utility.isValidPassword(password.toString())) {
                binding.txtInputLayoutPassword.error = getString(R.string.weakPasswordMessage)
            } else {
                binding.txtInputLayoutPassword.error = null
            }

        }
        binding.etxtEmail.addTextChangedListener { email ->
            if (!Utility.isEmailValid(email.toString())) {
                binding.txtInputLayoutEmail.error = getString(R.string.invalidEmailMessage)
            } else {
                binding.txtInputLayoutEmail.error = null
            }
        }
        binding.btnSignUp.setOnClickListener {
            if (!isAllFieldsValid()) {
                Toast.makeText(this, "fill All Fields Properly", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DoctorHomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    /**
     * checking if all fields entered are  valid
     */
    private fun isAllFieldsValid(): Boolean {
        return (binding.txtInputLayoutEmail.error == null && binding.txtInputLayoutPassword.error == null && binding.etxtEmail.text?.isNotEmpty() ?: false && binding.etxtFullName.text?.isNotEmpty() ?: false && binding.etxtNumber.text?.length == 10)
    }
}