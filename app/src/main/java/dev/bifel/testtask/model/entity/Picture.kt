package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName


/**
 * Date: 08.10.2020
 * Time: 18:05
 *
 * @author Bohdan Ishchenko
 */
data class Picture(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
)