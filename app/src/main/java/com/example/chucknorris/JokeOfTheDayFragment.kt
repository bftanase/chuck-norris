package com.example.chucknorris

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.chucknorris.databinding.JokeOfTheDayFragmentBinding
import kotlinx.android.synthetic.main.joke_of_the_day_fragment.*


class JokeOfTheDayFragment : Fragment() {

    companion object {
        fun newInstance() = JokeOfTheDayFragment()
    }
    private lateinit var binding: JokeOfTheDayFragmentBinding

    private  val viewModel: JokeOfTheDayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nameObserver = Observer<String> {
            newJoke -> binding.joke = newJoke
        }

        viewModel.joke.observe(this, nameObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.randomJoke() // initialize

        binding = JokeOfTheDayFragmentBinding.inflate(layoutInflater);
        binding.viewCategoriesButton.setOnClickListener{
            val directions = JokeOfTheDayFragmentDirections.actionJokeOfTheDayFragmentToCategoriesFragment();
            Toast.makeText(requireContext(), "Changing fragment", Toast.LENGTH_LONG).show()
            findNavController().navigate(directions);
        }

        binding .anotherJokeButton.setOnClickListener{
            viewModel.randomJoke()
        }

        return binding.root
    }
}
