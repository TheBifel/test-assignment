package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value")
    val value: String? = null
)