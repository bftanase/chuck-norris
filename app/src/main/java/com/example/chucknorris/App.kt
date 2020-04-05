package com.example.chucknorris

import android.app.Application
import com.example.chucknorris.com.example.chucknorris.repositories.ChuckNorrisWebService
import com.example.chucknorris.com.example.chucknorris.repositories.JokesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize dependency injection
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

    private val appModule = module {
        single { ChuckNorrisWebService() }
        single { JokesRepository(get()) }
        viewModel { JokeOfTheDayViewModel(get()) }
    }
}