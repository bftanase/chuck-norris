package ro.btanase.chucknorris.repositories

import ro.btanase.chucknorris.models.Joke

class JokesRepository (private val webService: ChuckNorrisWebService) {

    suspend fun getRandomJoke() : Joke {
        return webService.getRandomJoke()
    }

    suspend fun getCategories(): List<String> {
        return listOf("One category", "Another Category");
    }
}