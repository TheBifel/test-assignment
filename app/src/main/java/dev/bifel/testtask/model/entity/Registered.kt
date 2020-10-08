package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("age")
    val age: Int? = null,
)
