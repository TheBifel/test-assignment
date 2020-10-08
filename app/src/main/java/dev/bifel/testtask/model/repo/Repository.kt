package dev.bifel.testtask.model.repo

import dev.bifel.testtask.model.entity.User
import io.reactivex.Single

/**
 * Date: 08.10.2020
 * Time: 18:12
 *
 * @author Bohdan Ishchenko
 */
interface Repository {
    fun getUsers(): Single<List<User>>
}