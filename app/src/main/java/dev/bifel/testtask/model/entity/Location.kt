package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Date: 08.10.2020
 * Time: 18:02
 *
 * @author Bohdan Ishchenko
 */
data class Location(
    @SerializedName("street")
    val street: Street? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("postcode")
    val postcode: String? = null,
    @SerializedName("coordinates")
    val coordinates: Coordinates? = null,
    @SerializedName("timezone")
    val timezone: TimeZone? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Street::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Coordinates::class.java.classLoader),
        parcel.readParcelable(TimeZone::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(street, flags)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(postcode)
        parcel.writeParcelable(coordinates, flags)
        parcel.writeParcelable(timezone, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location = Location(parcel)

        override fun newArray(size: Int): Array<Location?> = arrayOfNulls(size)
    }
}