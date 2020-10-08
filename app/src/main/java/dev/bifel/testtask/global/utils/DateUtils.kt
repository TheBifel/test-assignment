package dev.bifel.testtask.global.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Date: 08.10.2020
 * Time: 22:45
 *
 * @author Bohdan Ishchenko
 */

const val TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

fun convertTimestampToDateString(time: String?): String? {
    time ?: return null
    try {
        val inputFormat = SimpleDateFormat(TIMESTAMP_PATTERN, Locale.ENGLISH)
        val sdf = SimpleDateFormat("YYYY-mm-dd", Locale.getDefault())
        val parse = inputFormat.parse(time) ?: return null
        return sdf.format(parse)
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }
}