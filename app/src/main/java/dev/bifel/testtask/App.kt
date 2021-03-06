package dev.bifel.testtask

import android.app.Application
import dev.bifel.testtask.di.presenterModule
import dev.bifel.testtask.di.repositoryModule
import dev.bifel.testtask.di.retrofitModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.KoinComponent

/**
 * Date: 08.10.2020
 * Time: 17:47
 *
 * @author Bohdan Ishchenko
 */
class App : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(retrofitModule, repositoryModule, presenterModule))
    }
}