package ro.btanase.chucknorris.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category")
data class Category (
    @PrimaryKey
    @ColumnInfo(name="name")
    val name : String
)