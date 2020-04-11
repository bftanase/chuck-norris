package ro.btanase.chucknorris.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ro.btanase.chucknorris.databinding.JokeOfTheDayFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel
import kotlinx.coroutines.launch
import ro.btanase.chucknorris.models.Joke


class JokeOfTheDayFragment : Fragment() {

    private lateinit var binding: JokeOfTheDayFragmentBinding
    private val args: JokeOfTheDayFragmentArgs by navArgs()

    private  val viewModel: JokeOfTheDayViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nameObserver = Observer<Joke> {
            newJoke -> binding.joke = newJoke
        }

        viewModel.joke.observe(this, nameObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifecycleScope.launch {
            viewModel.randomJoke()
        }
         // initialize

        binding = JokeOfTheDayFragmentBinding.inflate(layoutInflater);
        binding.viewCategoriesButton.setOnClickListener{
            val directions =
                JokeOfTheDayFragmentDirections.actionJokeOfTheDayFragmentToCategoriesFragment();
            findNavController().navigate(directions);
        }

        Toast.makeText(requireContext(), "Changing fragment: " , Toast.LENGTH_LONG).show()

        binding.anotherJokeButton.setOnClickListener{
            lifecycleScope.launch {
                viewModel.randomJoke()
            }
        }

        return binding.root
    }
}
