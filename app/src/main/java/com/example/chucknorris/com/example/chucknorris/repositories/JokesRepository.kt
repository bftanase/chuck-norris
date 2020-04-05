package com.example.chucknorris.com.example.chucknorris.repositories

import com.example.chucknorris.com.example.chucknorris.models.Joke

class JokesRepository (private val webService: ChuckNorrisWebService) {

    suspend fun getRandomJoke() : Joke {
        return webService.getRandomJoke()
    }
}