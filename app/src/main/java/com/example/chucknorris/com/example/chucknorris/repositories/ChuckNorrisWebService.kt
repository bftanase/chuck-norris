package com.example.chucknorris.com.example.chucknorris.repositories

import com.example.chucknorris.com.example.chucknorris.models.Joke
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ChuckNorrisWebService {
    private val api :ChuckNorrisApi by lazy {
//        var gson = GsonBuilder()
//            .create()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckNorrisApi::class.java)
    }

    suspend fun getRandomJoke() : Joke  = api.getRandomJoke()

    interface ChuckNorrisApi {

        @GET("random")
        suspend fun getRandomJoke() : Joke
    }

    companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }
}