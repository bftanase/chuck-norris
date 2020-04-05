package com.example.chucknorris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorris.com.example.chucknorris.repositories.JokesRepository

class JokeOfTheDayViewModel(private val jokesRepository: JokesRepository) : ViewModel() {

    val joke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val jokeList = listOf<String>("JOke 1", "Joke 2", "Joke 3", "Joke 4")

    suspend fun randomJoke() {
        joke.value = jokesRepository.getRandomJoke().text
    }

}
