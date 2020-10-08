package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("age")
    var age: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeValue(age)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Dob> {
        override fun createFromParcel(parcel: Parcel): Dob = Dob(parcel)

        override fun newArray(size: Int): Array<Dob?> = arrayOfNulls(size)
    }
}