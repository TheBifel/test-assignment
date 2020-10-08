package dev.bifel.testtask.di

import com.google.gson.GsonBuilder
import dev.bifel.testtask.common.BASE_URL
import dev.bifel.testtask.model.api.UsersApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Date: 08.10.2020
 * Time: 17:52
 *
 * @author Bohdan Ishchenko
 */

val retrofitModule = applicationContext {
    bean {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UsersApi::class.java)
    }
}
