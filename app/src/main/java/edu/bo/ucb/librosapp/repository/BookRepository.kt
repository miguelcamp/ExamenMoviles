package edu.bo.ucb.librosapp.repository

import edu.bo.ucb.librosapp.data.IBookDao
import edu.bo.ucb.librosapp.model.Book

class BookRepository(private val bookDao: IBookDao) {

    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }

    fun getListBooks(): List<Book> {
        return bookDao.getList()
    }
}
