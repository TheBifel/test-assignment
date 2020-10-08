package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName


/**
 * Date: 08.10.2020
 * Time: 18:04
 *
 * @author Bohdan Ishchenko
 */
data class Name(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null,
)