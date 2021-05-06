package edu.bo.ucb.librosapp.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController
import edu.bo.ucb.librosapp.R
import edu.bo.ucb.librosapp.model.Book
import edu.bo.ucb.librosapp.viewmodel.BookListViewModel
import kotlinx.android.synthetic.main.fragment_update_book.*
import kotlinx.android.synthetic.main.fragment_update_book.view.*


class UpdateBookFragment : Fragment() {
    private val args by navArgs<UpdateBookFragmentArgs>()
    private lateinit var bookListViewModel : BookListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_update_book, container, false)

        bookListViewModel = ViewModelProvider(this).get(BookListViewModel::class.java)

        view.titleUpdateText.setText(args.currentBook.title)
        view.ISBNUpdateText.setText(args.currentBook.isbn)
        view.AuthorUpdateText.setText(args.currentBook.author)
        view.publishDateUpdateText.setText(args.currentBook.publishDate)
        view.pagesUpdateText.setText(args.currentBook.pages.toString())
        view.descriptionUpdateText.setText(args.currentBook.description)
        view.coverPageUrlUpdateText.setText(args.currentBook.coverPageUrl)

        view.update_book_btn.setOnClickListener {
            updateItem()
        }
        view.delete_btn.setOnClickListener {
            deleteItem()
        }

        return  view
    }
    private  fun updateItem(){
        val title = titleUpdateText.text.toString()
        val isbn = ISBNUpdateText.text.toString()
        val author = AuthorUpdateText.text.toString()
        val publishDate = publishDateUpdateText.text.toString()
        val pages = pagesUpdateText.text.toString().toInt()
        val description = descriptionUpdateText.text.toString()
        val coverPageUrl = coverPageUrlUpdateText.text.toString()

        if(isValid(title, isbn, author, publishDate, description, coverPageUrl)){
            val updateBook = Book(args.currentBook.id, title,isbn,author,publishDate,pages,description,coverPageUrl)
             // = Book (args.currentBook.id, title, pages, editorial, author, description, photoUrl)
            bookListViewModel.updateBook(updateBook)
            Toast.makeText(requireContext(), "Book updated successfully", Toast.LENGTH_SHORT).show()
            // Go to List
            findNavController().navigate(R.id.action_updateBookFragment_to_bookListFragment)
        }else{
            Toast.makeText(requireContext(), "All fields must be filled", Toast.LENGTH_SHORT).show()
        }
    }
    private fun deleteItem(){
        bookListViewModel.deleteBook(args.currentBook)
        Toast.makeText(requireContext(), "Book deleted successfully", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updateBookFragment_to_bookListFragment)
    }

    private fun isValid (title:String, isbn:String, author: String, publishDate: String, description: String, coverPageUrl: String): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(isbn) && TextUtils.isEmpty(author) && TextUtils.isEmpty(description) && TextUtils.isEmpty(coverPageUrl) && TextUtils.isEmpty(publishDate)  )
    }

}