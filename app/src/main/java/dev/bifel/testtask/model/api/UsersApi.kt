package dev.bifel.testtask.model.api

import dev.bifel.testtask.model.entity.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Date: 08.10.2020
 * Time: 17:55
 *
 * @author Bohdan Ishchenko
 */
interface UsersApi {
    @GET("api/")
    fun getUsers(
        @Query("page") page: Int,
        @Query("results") numberOfUsers: Int
    ): Single<Response>
}