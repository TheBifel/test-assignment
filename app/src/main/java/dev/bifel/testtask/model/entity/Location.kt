package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName

/**
 * Date: 08.10.2020
 * Time: 18:02
 *
 * @author Bohdan Ishchenko
 */
data class Location(
    @SerializedName("street")
    val street: String? = null,
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
)