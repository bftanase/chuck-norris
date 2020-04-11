package ro.btanase.chucknorris

import android.app.Application
import ro.btanase.chucknorris.repositories.ChuckNorrisWebService
import ro.btanase.chucknorris.repositories.JokesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ro.btanase.chucknorris.ui.CategoriesViewModel
import ro.btanase.chucknorris.ui.JokeOfTheDayViewModel

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
        viewModel { CategoriesViewModel(get()) }
        viewModel { JokeOfTheDayViewModel(get()) }
    }
}