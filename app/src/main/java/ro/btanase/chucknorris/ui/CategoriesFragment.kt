package ro.btanase.chucknorris.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import ro.btanase.chucknorris.R
import ro.btanase.chucknorris.databinding.CategoriesFragmentBinding


class CategoriesFragment : Fragment() {
    private lateinit var binding: CategoriesFragmentBinding
    private val viewModel: CategoriesViewModel by viewModel()
    private val adapter  = CategoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoriesFragmentBinding.inflate(layoutInflater)
        binding.categoriesList.adapter = adapter
        binding.categoriesList.setHasFixedSize(true)
//        val layoutManager = LinearLayoutManager(activity)
//        binding.categoriesList.layoutManager = layoutManager
//        binding.categoriesList.layoutMode =

        lifecycleScope.launch {
            adapter.submitList(viewModel.getCategories())
        }

        viewModel.onItemClickListener = onItemClickListener
        return binding.root
    }

    override fun onDestroyView() {
        viewModel.onItemClickListener = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private val onItemClickListener: OnCategoryClickListener = { category ->
        findNavController().navigate(CategoriesFragmentDirections.actionCategoriesFragmentToJokeOfTheDayFragment(category))
    }
}
