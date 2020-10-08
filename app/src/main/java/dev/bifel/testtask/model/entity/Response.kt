package dev.bifel.testtask.model.entity

import com.google.gson.annotations.SerializedName

/**
 * Date: 08.10.2020
 * Time: 19:20
 *
 * @author Bohdan Ishchenko
 */

data class Response(
    @SerializedName("results")
    val results: List<User>? = null,
    @SerializedName("info")
    val info: Info
)