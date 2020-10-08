package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


/**
 * Date: 08.10.2020
 * Time: 18:05
 *
 * @author Bohdan Ishchenko
 */
data class Picture(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(large)
        parcel.writeString(medium)
        parcel.writeString(thumbnail)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Picture> {
        override fun createFromParcel(parcel: Parcel): Picture = Picture(parcel)

        override fun newArray(size: Int): Array<Picture?> = arrayOfNulls(size)
    }
}