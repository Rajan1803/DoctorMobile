package com.example.doctormobile.helpers

import com.example.doctormobile.model.Doctor
import java.text.FieldPosition

interface OnButtonClick {
    fun onBtnSubmitClick(doctor: Doctor?)
}