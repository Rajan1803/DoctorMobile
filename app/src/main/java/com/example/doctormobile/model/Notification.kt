package com.example.doctormobile.model

import com.example.doctormobile.R

data class Notification(val image: Int, val title: String, val subtitle: String, val time: String) {


    companion object {
        val notifications = arrayListOf<Notification>(Notification(R.drawable.notification_icon,
            "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
            Notification(R.drawable.notification_profile,
            "Dr.Upul","Corem ipsum dolor sit amet,adipiscing elit.","12.50")
        ,Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
            Notification(R.drawable.notification_profile,
                "Dr.Upul","Corem ipsum dolor sit amet,adipiscing elit.","12.50")
        ,Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
            Notification(R.drawable.notification_profile,
                "Dr.Upul","Corem ipsum dolor sit amet,adipiscing elit.","12.50"),
            Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
            Notification(R.drawable.notification_profile,
                "Dr.Upul","Corem ipsum dolor sit amet,adipiscing elit.","12.50")
            ,Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
            Notification(R.drawable.notification_profile,
                "Dr.Upul","Corem ipsum dolor sit amet,adipiscing elit.","12.50")
            ,Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min")
        ,Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
            Notification(R.drawable.notification_profile,
                "Dr.Upul","Corem ipsum dolor sit amet,adipiscing elit.","12.50")
            ,Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
            Notification(R.drawable.notification_profile,
                "Dr.Upul","Corem ipsum dolor sit amet,adipiscing elit.","12.50")
            ,Notification(R.drawable.notification_icon,
                "April 2023","Corem ipsum dolor sit amet,adipiscing elit.","15 Min"),
        )
    }
}