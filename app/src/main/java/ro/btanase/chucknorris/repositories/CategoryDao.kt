package ro.btanase.chucknorris.repositories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ro.btanase.chucknorris.models.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category")
    suspend fun getCategories(): List<Category>

    @Insert
    suspend fun saveCategory(categories : List<Category>)

    @Query("DELETE FROM Category")
    suspend fun clearCategories()
}