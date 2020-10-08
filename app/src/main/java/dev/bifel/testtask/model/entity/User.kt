package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("gender")
    val gender: String? = null,

    @SerializedName("name")
    val name: Name? = null,

    @SerializedName("location")
    val location: Location? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("login")
    val login: Login? = null,

    @SerializedName("dob")
    val dob: Dob? = null,

    @SerializedName("registered")
    val registered: Registered? = null,

    @SerializedName("phone")
    val phone: String? = null,

    @SerializedName("cell")
    val cell: String? = null,

    @SerializedName("id")
    val id: Id? = null,

    @SerializedName("picture")
    val picture: Picture? = null,

    @SerializedName("nat")
    val nat: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Name::class.java.classLoader),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Login::class.java.classLoader),
        parcel.readParcelable(Dob::class.java.classLoader),
        parcel.readParcelable(Registered::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Id::class.java.classLoader),
        parcel.readParcelable(Picture::class.java.classLoader),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(email)
        parcel.writeParcelable(login, flags)
        parcel.writeParcelable(dob, flags)
        parcel.writeParcelable(registered, flags)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeParcelable(id, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeString(nat)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel) = User(parcel)

        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
}