package edu.bo.ucb.librosapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.bo.ucb.librosapp.data.BookDatabase
import edu.bo.ucb.librosapp.data.BookRepository
import edu.bo.ucb.librosapp.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookListViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Book>>
    private val repository: BookRepository
    init{
        val bookDao= BookDatabase.getDatabase(
            application
        ).bookDao()
        repository = BookRepository(bookDao)
        readAllData = repository.readAllData
    }

    fun addBook (book: Book){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(book)
        }
    }

    fun updateBook (book: Book){
        viewModelScope.launch (Dispatchers.IO){
            repository.update(book)
        }
    }

    fun deleteBook(book: Book){
        viewModelScope.launch (Dispatchers.IO){
            repository.delete(book)
        }
    }
}