package dev.bifel.testtask.pages.list

import dev.bifel.testtask.global.base.*

/**
 * Date: 08.10.2020
 * Time: 18:16
 *
 * @author Bohdan Ishchenko
 */
class ListPresenter : BasePresenter<ListView>() {
    fun initUsers() {
        repository.getUsers()
            .toAsync()
            .showLoading(view)
            .subscribe(view) { view?.showUsers(it) }
            .register(this)
    }
}