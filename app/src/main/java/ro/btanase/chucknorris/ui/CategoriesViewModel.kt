package ro.btanase.chucknorris.ui

import androidx.lifecycle.ViewModel
import ro.btanase.chucknorris.repositories.JokesRepository

class CategoriesViewModel(private val repository : JokesRepository) : ViewModel() {

    var onItemClickListener: OnCategoryClickListener? = null

    suspend fun getCategories() : List<CategoryViewModel> {
        return repository.getCategories()
            .map { category -> CategoryViewModel(category) }
    }

    inner class CategoryViewModel(val category: String) {
        fun onItemClicked() {
            onItemClickListener?.invoke(category)
        }
    }
}

/**
 * A shortcut for a method call for when a [ItemDayBinding] is clicked.
 */
typealias OnCategoryClickListener = (category: String) -> Unit