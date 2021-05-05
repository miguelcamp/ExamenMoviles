package edu.bo.ucb.librosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.bo.ucb.librosapp.data.BookDatabase
import edu.bo.ucb.librosapp.model.Book
import edu.bo.ucb.librosapp.repository.BookRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val bookDao = BookDatabase.getDatabase(applicationContext).bookDao()
            val repository = BookRepository(bookDao)
            //repository.insert(Book("Arcanum Unbounded", "978-0-7653-9116-2","Brandon Sanderson", "2016", 671, "Welcome to New York Times and Sunday Times bestseller Brandon Sanderson's first collection of short fiction.", "https://coppermind.net/wiki/Arcanum_Unbounded#/media/File:Arcanum_Unbounded.jpg"))
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}")
            }
        }

    }
}