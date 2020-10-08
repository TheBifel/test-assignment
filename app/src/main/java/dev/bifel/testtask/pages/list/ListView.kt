package dev.bifel.testtask.pages.list

import dev.bifel.testtask.global.base.BaseView
import dev.bifel.testtask.model.entity.User

/**
 * Date: 08.10.2020
 * Time: 18:28
 *
 * @author Bohdan Ishchenko
 */
interface ListView : BaseView {
    fun showUsers(users: List<User>)
}