package ro.btanase.chucknorris.ui
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import ro.btanase.chucknorris.models.Joke
import ro.btanase.chucknorris.repositories.JokesRepository

class JokeOfTheDayViewModel(private val jokesRepository: JokesRepository) : ViewModel() {

    val joke: MutableLiveData<Joke> by lazy {
        MutableLiveData<Joke>()
    }

    private val jokeList = listOf<String>("JOke 1", "Joke 2", "Joke 3", "Joke 4")

    suspend fun randomJoke() {
        joke.value = jokesRepository.getRandomJoke()
    }
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl).into(view)
}
