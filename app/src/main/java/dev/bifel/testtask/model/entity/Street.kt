package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName

/**
 * Date: 08.10.2020
 * Time: 19:25
 *
 * @author Bohdan Ishchenko
 */
data class Street(
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("name")
    val name: String? = null,
)