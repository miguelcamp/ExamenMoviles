package edu.bo.ucb.librosapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import edu.bo.ucb.librosapp.R
import edu.bo.ucb.librosapp.viewmodel.BookListViewModel
import kotlinx.android.synthetic.main.book_list_fragment.view.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class BookListFragment : Fragment() {

    private lateinit var bookListViewModel: BookListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.book_list_fragment, container, false)

        // Recyclerview
        val adapter = BookListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //BookViewModel
        bookListViewModel = ViewModelProvider(this).get(BookListViewModel::class.java)
        bookListViewModel.readAllData.observe(viewLifecycleOwner, Observer{ book ->
            adapter.setData(book)
        })
        view.floatingAddButton.setOnClickListener{
            findNavController().navigate(R.id.action_bookListFragment_to_addBookFragment)
        }

        return view
    }


}