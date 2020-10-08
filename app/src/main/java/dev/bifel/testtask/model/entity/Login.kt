package dev.bifel.testtask.model.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


/**
 * Date: 08.10.2020
 * Time: 18:03
 *
 * @author Bohdan Ishchenko
 */
data class Login(
    @SerializedName("uuid")
    val uuid: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("salt")
    val salt: String? = null,
    @SerializedName("md5")
    val md5: String? = null,
    @SerializedName("sha1")
    val sha1: String? = null,
    @SerializedName("sha256")
    val sha256: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uuid)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(salt)
        parcel.writeString(md5)
        parcel.writeString(sha1)
        parcel.writeString(sha256)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Login> {
        override fun createFromParcel(parcel: Parcel): Login = Login(parcel)

        override fun newArray(size: Int): Array<Login?> = arrayOfNulls(size)
    }
}