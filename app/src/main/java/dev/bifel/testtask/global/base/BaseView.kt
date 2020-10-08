package dev.bifel.testtask.global.base

/**
 * Date: 08.10.2020
 * Time: 18:25
 *
 * @author Bohdan Ishchenko
 */
interface BaseView {
    fun showLoading(isLoading: Boolean)
    fun showError(errorMsg: String)
}