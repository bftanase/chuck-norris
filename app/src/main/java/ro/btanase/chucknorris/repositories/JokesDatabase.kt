package ro.btanase.chucknorris.repositories

import androidx.room.Database
import androidx.room.RoomDatabase
import ro.btanase.chucknorris.models.Category

@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class JokesDatabase: RoomDatabase() {
    abstract fun categoryDao(): CategoryDao?

    companion object {
        const val DATABASE_NAME: String = "jokes.db"
    }
}