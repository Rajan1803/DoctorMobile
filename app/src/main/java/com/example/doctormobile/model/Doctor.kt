package com.example.doctormobile.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Doctor(

    @SerializedName("data_id")
    val dataId: String?,

    @SerializedName("desc")
    val description: String?,

    @SerializedName("id")
    val id: String?,

    @SerializedName("image")
    val image: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("rating")
    val rating: String?,

    @SerializedName("type")
    val type: String?,

    var isSelected: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dataId)
        parcel.writeString(description)
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(name)
        parcel.writeString(rating)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Doctor> {
        override fun createFromParcel(parcel: Parcel): Doctor {
            return Doctor(parcel)
        }

        override fun newArray(size: Int): Array<Doctor?> {
            return arrayOfNulls(size)
        }
    }

}