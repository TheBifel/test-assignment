package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value")
    val value: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Id> {
        override fun createFromParcel(parcel: Parcel): Id = Id(parcel)

        override fun newArray(size: Int): Array<Id?> = arrayOfNulls(size)
    }
}