package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TimeZone(
    @SerializedName("offset")
    val offset: String? = null,
    @SerializedName("description")
    val description: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(offset)
        parcel.writeString(description)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<TimeZone> {
        override fun createFromParcel(parcel: Parcel) = TimeZone(parcel)

        override fun newArray(size: Int): Array<TimeZone?> = arrayOfNulls(size)
    }
}
