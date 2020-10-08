package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


/**
 * Date: 08.10.2020
 * Time: 18:04
 *
 * @author Bohdan Ishchenko
 */
data class Name(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(first)
        parcel.writeString(last)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Name> {
        override fun createFromParcel(parcel: Parcel): Name = Name(parcel)

        override fun newArray(size: Int): Array<Name?> = arrayOfNulls(size)
    }
}