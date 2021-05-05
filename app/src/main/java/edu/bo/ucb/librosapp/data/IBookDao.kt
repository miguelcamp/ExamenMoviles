package edu.bo.ucb.librosapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.bo.ucb.librosapp.model.Book

@Dao
interface IBookDao {

    @Query("SELECT * FROM book_table ORDER BY id ASC")
    fun getList(): List<Book>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book:Book)

    @Query("DELETE FROM book_table")
    suspend fun deleteAll()
}
