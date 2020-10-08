package dev.bifel.testtask.model.repo

import dev.bifel.testtask.global.common.DEFAULT_PAGE_SIZE
import dev.bifel.testtask.model.api.UsersApi
import dev.bifel.testtask.model.entity.User
import io.reactivex.Single

/**
 * Date: 08.10.2020
 * Time: 18:13
 *
 * @author Bohdan Ishchenko
 */
class RepositoryImpl(private val api: UsersApi) : Repository {

    override fun getUsers(page: Int): Single<List<User>> =
        api.getUsers(page, DEFAULT_PAGE_SIZE)
            .map { it.results }
}