package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Date: 08.10.2020
 * Time: 19:25
 *
 * @author Bohdan Ishchenko
 */
data class Street(
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("name")
    val name: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(number)
        parcel.writeString(name)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Street> {
        override fun createFromParcel(parcel: Parcel) = Street(parcel)

        override fun newArray(size: Int): Array<Street?> = arrayOfNulls(size)
    }
}