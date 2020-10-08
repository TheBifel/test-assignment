package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName

data class TimeZone(
    @SerializedName("offset")
    val offset: String? = null,
    @SerializedName("description")
    val description: String? = null,
)
