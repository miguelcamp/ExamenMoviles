package edu.bo.ucb.librosapp.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import edu.bo.ucb.librosapp.R
import edu.bo.ucb.librosapp.model.Book
import edu.bo.ucb.librosapp.viewmodel.BookListViewModel
import kotlinx.android.synthetic.main.fragment_add_book.*
import kotlinx.android.synthetic.main.fragment_add_book.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [AddBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddBookFragment : Fragment() {
    private lateinit var bookListViewModel: BookListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_book, container, false)
        bookListViewModel = ViewModelProvider(this).get(BookListViewModel::class.java)
        view.addBook_btn.setOnClickListener {
            insertBook()
        }
        return view
    }

    private fun insertBook(){
        //titulo, isbn, autor, fecha publicacion, nro de paginas, descripcion breve, url foto portada
        val title = titleTextField.text.toString()
        val isbn = ISBNTextField.text.toString()
        val author = AuthorTextField.text.toString()
        val publishDate = publishDateTextField.text.toString()
        val pages = pagesTextField.text.toString().toInt()
        val description = DescriptionTextField.text.toString()
        val coverPageUrl = coverPageUrlTextField.text.toString()

        if(isValid(title, isbn, author, publishDate, description, coverPageUrl)){
            val book = Book(0,title,isbn,author,publishDate,pages,description,coverPageUrl)
            bookListViewModel.addBook(book)
            Toast.makeText(requireContext(), "Book was added successfully", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(requireContext(), "All fields must be filled", Toast.LENGTH_LONG).show()
        }


    }
    private fun isValid (title:String, isbn:String, author: String, publishDate: String, description: String, coverPageUrl: String): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(isbn) && TextUtils.isEmpty(author) && TextUtils.isEmpty(description) && TextUtils.isEmpty(coverPageUrl) && TextUtils.isEmpty(publishDate)  )
    }

}