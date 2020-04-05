package com.example.chucknorris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JokeOfTheDayViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val joke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val jokeList = listOf<String>("JOke 1", "Joke 2", "Joke 3", "Joke 4")

    fun randomJoke() {
        joke.value = jokeList.random();
    }

}
