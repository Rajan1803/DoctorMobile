package com.example.doctormobile.model

import android.accounts.AuthenticatorDescription
import com.example.doctormobile.R

class Doctor(val image: Int, val name: String, val description: String, val ratting: Float,
             var isFavourite: Boolean) {

    companion object {
        val doctors = arrayListOf<Doctor>(
            Doctor(R.drawable.doctor,"Dr.Pawan",
            "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true),
            Doctor(R.drawable.doctor_second,"Dr.Wanitha",
            "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true)
            , Doctor(R.drawable.doctor_third,"Dr.Udara",
            "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true),
            Doctor(R.drawable.doctor_fourth,"Dr.Pawan",
                "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true),
            Doctor(R.drawable.doctor,"Dr.Wanitha",
                "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true)
            , Doctor(R.drawable.doctor_second,"Dr.Udara",
                "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true),
            Doctor(R.drawable.doctor_third,"Dr.Pawan",
                "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true),
            Doctor(R.drawable.doctor_fourth,"Dr.Wanitha",
                "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true)
            , Doctor(R.drawable.doctor,"Dr.Udara",
                "Jorem ipsum dolor, consectetur adipiscing elit. Nunc v libero et velit interdum, ac  mattis.",5.0f,true)
        )

    }

}