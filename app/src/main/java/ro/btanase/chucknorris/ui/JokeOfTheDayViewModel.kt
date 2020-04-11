package ro.btanase.chucknorris.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import ro.btanase.chucknorris.models.AppSharedPreferences
import ro.btanase.chucknorris.models.Joke
import ro.btanase.chucknorris.repositories.JokesRepository

class JokeOfTheDayViewModel(
    private val jokesRepository: JokesRepository,
    private val sharedPreferences: AppSharedPreferences
) : ViewModel() {

    val selectedCategory: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val joke: MutableLiveData<Joke> by lazy {
        MutableLiveData<Joke>()
    }

    suspend fun randomJoke() {
        joke.value = jokesRepository.getRandomJoke(selectedCategory.value!!)
    }

    suspend fun selectCategory(category: String) {
        if (category == "NOT_SET")
            selectedCategory.value = sharedPreferences.lastCategory
        else
            selectedCategory.value = category

        joke.value = jokesRepository.getRandomJoke(selectedCategory.value!!)
        sharedPreferences.lastCategory = selectedCategory.value!!
    }
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl).into(view)
}
