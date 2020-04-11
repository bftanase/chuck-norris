package ro.btanase.chucknorris.repositories

import ro.btanase.chucknorris.models.AppSharedPreferences
import ro.btanase.chucknorris.models.Category
import ro.btanase.chucknorris.models.Joke
import java.util.*

class JokesRepository(
    private val webService: ChuckNorrisWebService,
    private val sharedPreferences: AppSharedPreferences,
    private val categoryDao: CategoryDao
) {

    suspend fun getRandomJoke(category: String = "ALL"): Joke {
        if (category == "ALL") {
            return webService.getRandomJoke(null)
        } else {
            return webService.getRandomJoke(category)
        }
    }

    suspend fun getCategories(): List<String> {
        val lastSyncDate = sharedPreferences.lastSyncDate
        // If we haven't yet synced with the backend or the cache has expired
        if (lastSyncDate == null || lastSyncDate.isCacheExpired()) {

            val categories = listOf("ALL") + webService.getCategories();
            categories.also {
                // clear old cache
                categoryDao.clearCategories();

                // save category object to the database, converting from simple list of strings
                // to Category objects
                categoryDao.saveCategory(it.map { categoryName -> Category(categoryName) })

                // update the last sync date
                sharedPreferences.lastSyncDate = Date()
            }
            return categories
        }

        return categoryDao.getCategories().map { categoryRow -> categoryRow.name }
    }

    /**
     * Utility method used to check if the database cache is expired based on the last sync [Date].
     */
    private fun Date.isCacheExpired() = this < Date().minusTime(CACHE_EXPIRATION_TIME)

    /**
     * Utility method used to subtract the given [millis] from this [Date].
     */
    private fun Date.minusTime(millis: Long) = Date(time - millis)

    companion object {
        /**
         * After how long the database cache is considered as expired, 1 minute.
         */
        const val CACHE_EXPIRATION_TIME = 1 * 60 * 1000L
    }
}