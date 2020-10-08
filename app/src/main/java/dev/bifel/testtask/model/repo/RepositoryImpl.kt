package dev.bifel.testtask.model.repo

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

    override fun getUsers(): Single<List<User>> =
        api.getUsers(1, 20)
            .map { it.results }
}