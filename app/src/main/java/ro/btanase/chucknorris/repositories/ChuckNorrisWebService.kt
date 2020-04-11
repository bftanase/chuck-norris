package ro.btanase.chucknorris.repositories

import ro.btanase.chucknorris.models.Joke
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ChuckNorrisWebService {
    private val api :ChuckNorrisApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckNorrisApi::class.java)
    }

    suspend fun getRandomJoke(category: String?) : Joke  = api.getRandomJoke(category)
    suspend fun getCategories() : List<String> = api.getCategories()

    interface ChuckNorrisApi {

        @GET("random")
        suspend fun getRandomJoke(@Query("category") category: String?) : Joke

        @GET("categories")
        suspend fun getCategories() : List<String>
    }

    companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }
}