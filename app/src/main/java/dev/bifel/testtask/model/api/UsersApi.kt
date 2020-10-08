package dev.bifel.testtask.model.api

import dev.bifel.testtask.model.entity.User
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Date: 08.10.2020
 * Time: 17:55
 *
 * @author Bohdan Ishchenko
 */
interface UsersApi {
    @GET("/")
    fun getUsers(@Query("results") numberOfUsers: Int): List<User>
}