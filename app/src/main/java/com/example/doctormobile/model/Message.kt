package com.example.doctormobile.model

import com.example.doctormobile.R

class Message(val image: Int,val name: String, val message: String, val time: String, val unseenMessages: Int) {

    companion object {
        val messages = arrayListOf<Message>(Message(
            R.drawable.chat_user_first,
            "Dr.Upul","Worem consectetur adipiscing elit.","12.50",2),
            Message(R.drawable.chat_user_second,"Dr.Silva","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_third,"Dr.Pawani","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_fourth,"Dr.Rayan","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_fifth,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_first,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_first,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_first,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_first,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_first,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_first,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0),
            Message(R.drawable.chat_user_first,"Dr.Upul","Worem consectetur adipiscing elit.","12.50",0)
        )

    }
}