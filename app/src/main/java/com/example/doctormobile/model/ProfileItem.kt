package com.example.doctormobile.model

import com.example.doctormobile.R

data class ProfileItem(val logo: Int,val title: String) {

    companion object {
        val items = arrayListOf<ProfileItem>(ProfileItem(R.drawable.history_logo,"History")
        ,ProfileItem(R.drawable.personal_details_logo,"Personal Detailes"),ProfileItem(R.drawable.location_logo,"Location")
        ,ProfileItem(R.drawable.wallet_logo,"Payment Method"),ProfileItem(R.drawable.settings_logo,"Settings"),
            ProfileItem(R.drawable.help_logo,"Help"),ProfileItem(R.drawable.logout_logo,"Logout"))
    }
}