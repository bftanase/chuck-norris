package ro.btanase.chucknorris.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ro.btanase.chucknorris.R


class MainActivity : AppCompatActivity() {
    private var jokeList = listOf("One Joke", "Another One", "And Yet Another One");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val randomJoke = jokeList.random();
//        val tvJoke = findViewById<TextView>(R.id.textView);
//        tvJoke.text = randomJoke;
    }

    fun onBtnGetJokesClick(view: View) {
//        val randomJoke = jokeList.random();
//        val tvJoke = findViewById<TextView>(R.id.textView);
//        tvJoke.text = randomJoke;
    }


}
