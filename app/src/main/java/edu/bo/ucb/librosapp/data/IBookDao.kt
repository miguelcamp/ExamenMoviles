package edu.bo.ucb.librosapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.bo.ucb.librosapp.model.Book

@Dao
interface IBookDao {

    @Query("SELECT * FROM book_table ORDER BY id ASC")
    fun getList(): List<Book>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book:Book)

    @Query("DELETE FROM book_table")
    suspend fun deleteAll()

    @Update
    suspend fun updateBook(book: Book)

    @Query( "SELECT * FROM book_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Book>>
}
