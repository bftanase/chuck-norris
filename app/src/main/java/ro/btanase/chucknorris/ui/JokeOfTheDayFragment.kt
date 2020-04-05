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
import ro.btanase.chucknorris.databinding.JokeOfTheDayFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel
import kotlinx.coroutines.launch


class JokeOfTheDayFragment : Fragment() {

    companion object {
        fun newInstance() = JokeOfTheDayFragment()
    }
    private lateinit var binding: JokeOfTheDayFragmentBinding

    private  val viewModel: JokeOfTheDayViewModel by viewModel()

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
        lifecycleScope.launch {
            viewModel.randomJoke()
        }
         // initialize

        binding = JokeOfTheDayFragmentBinding.inflate(layoutInflater);
        binding.viewCategoriesButton.setOnClickListener{
            val directions =
                JokeOfTheDayFragmentDirections.actionJokeOfTheDayFragmentToCategoriesFragment();
            Toast.makeText(requireContext(), "Changing fragment", Toast.LENGTH_LONG).show()
            findNavController().navigate(directions);
        }

        binding.anotherJokeButton.setOnClickListener{
            lifecycleScope.launch {
                viewModel.randomJoke()
            }
        }

        return binding.root
    }
}
