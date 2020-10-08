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
    private val large: String? = null,
    @SerializedName("medium")
    private val medium: String? = null,
    @SerializedName("thumbnail")
    private val thumbnail: String? = null,
)