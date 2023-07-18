package com.example.doctormobile.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.doctormobile.R
import com.example.doctormobile.databinding.ActivityWelcomeBinding
import com.example.doctormobile.helpers.LoginVMFactory
import com.example.doctormobile.model.LoginResponse
import com.example.doctormobile.repository.LoginRepository
import com.example.doctormobile.viewmodel.LoginViewModel

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
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.toolbar.toolbarTitle.text = getString(R.string.welcome)
        binding.toolbar.imgBack.visibility = View.GONE

        binding.etxtEmail.addTextChangedListener {
        }

        binding.etxtPassword.addTextChangedListener { pass ->
        }

        binding.btnSignIn.setOnClickListener {
            val loginViewModel = ViewModelProvider(
                this,
                LoginVMFactory(LoginRepository())
            ).get(LoginViewModel::class.java)
            loginViewModel.postLoginData(
                binding.etxtEmail.text?.toString(),
                binding.etxtPassword.text?.toString()
            ) { loginResponse ->
                signIn(loginResponse)
            }
        }

        binding.txtvAlreadyAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.txtvOR.setOnClickListener {
            val intent = Intent(this, DoctorHomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun signIn(loginResponse: LoginResponse?) {
        if (loginResponse == null) {
            Toast.makeText(this, "Enter Valid Username and Password", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, DoctorHomeActivity::class.java)
            startActivity(intent)
        }
    }

}