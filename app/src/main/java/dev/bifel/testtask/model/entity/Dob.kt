package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("age")
    var age: Int? = null
)