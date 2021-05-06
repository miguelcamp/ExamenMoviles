package edu.bo.ucb.librosapp.data

import androidx.lifecycle.LiveData
import edu.bo.ucb.librosapp.data.IBookDao
import edu.bo.ucb.librosapp.model.Book

class BookRepository(private val bookDao: IBookDao) {

    val readAllData: LiveData<List<Book>> = bookDao.readAllData()
    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }

    fun getListBooks(): List<Book> {
        return bookDao.getList()
    }

    suspend fun update(book: Book){
        bookDao.updateBook(book)
    }

    fun delete(book: Book){
        bookDao.deleteById(book)
    }
}
