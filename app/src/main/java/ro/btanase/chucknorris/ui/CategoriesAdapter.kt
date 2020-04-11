package ro.btanase.chucknorris.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ro.btanase.chucknorris.databinding.ItemCategoryBinding

class CategoriesAdapter : ListAdapter<CategoriesViewModel.CategoryViewModel, CategoriesAdapter.CategoryViewHolder>(DiffCallback())  {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding)
            : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryViewModel: CategoriesViewModel.CategoryViewModel) {
            binding.categoryViewModel = categoryViewModel
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<CategoriesViewModel.CategoryViewModel>() {
        override fun areItemsTheSame(
            oldItem: CategoriesViewModel.CategoryViewModel,
            newItem: CategoriesViewModel.CategoryViewModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoriesViewModel.CategoryViewModel,
            newItem: CategoriesViewModel.CategoryViewModel
        ): Boolean {
            return oldItem.category == newItem.category
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryViewModel = getItem(position)
        holder.bind(categoryViewModel)
    }
}