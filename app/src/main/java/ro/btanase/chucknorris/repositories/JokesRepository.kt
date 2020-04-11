package ro.btanase.chucknorris.repositories

import ro.btanase.chucknorris.models.Joke

class JokesRepository (private val webService: ChuckNorrisWebService) {

    suspend fun getRandomJoke(category: String = "ALL") : Joke {
        if (category == "ALL") {
            return webService.getRandomJoke(null)
        } else {
            return webService.getRandomJoke(category)
        }
    }

    suspend fun getCategories(): List<String> {
        val categories = listOf("ALL") + webService.getCategories();
        return categories
    }
}