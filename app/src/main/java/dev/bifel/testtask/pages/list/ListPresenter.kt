package dev.bifel.testtask.pages.list

import dev.bifel.testtask.global.base.*

/**
 * Date: 08.10.2020
 * Time: 18:16
 *
 * @author Bohdan Ishchenko
 */
class ListPresenter : BasePresenter<ListView>() {
    var isLoading: Boolean = false
    private var lastPage = 1

    fun initUsers() = loadUsers(1)

    fun loadMoreUsers() {
        if (!isLoading) loadUsers(++lastPage)
    }

    private fun loadUsers(page: Int) =
        repository.getUsers(page)
            .toAsync()
            .showLoading(view) { isLoading = it }
            .subscribe(view) {
                lastPage = page
                view?.showUsers(it)
            }
            .register(this)
}