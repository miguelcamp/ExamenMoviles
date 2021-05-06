package edu.bo.ucb.librosapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.bo.ucb.librosapp.R
import edu.bo.ucb.librosapp.model.Book
import kotlinx.android.synthetic.main.book.view.*

class BookListAdapter:  RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {
    private var bookList = emptyList<Book>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book, parent, false))
    }

    override fun getItemCount(): Int {
        return  bookList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val picasso = Picasso.get()
        val currentItem =  bookList[position]
        holder.itemView.idText.text = currentItem.id.toString()
        holder.itemView.titleText.text = currentItem.title
        holder.itemView.isbnText.text = currentItem.isbn
        holder.itemView.publishDateText.text = currentItem.publishDate
        holder.itemView.authorText.text = currentItem.author
        holder.itemView.pagesText.text = currentItem.pages.toString()
        holder.itemView.descriptionText.text = currentItem.description

        picasso.load(currentItem.coverPageUrl)
            .into(holder.itemView.imageView2)

        holder.itemView.bookLayout.setOnClickListener {
            val action = BookListFragmentDirections.actionBookListFragmentToUpdateBookFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData (books : List <Book>){
        this.bookList = books
        notifyDataSetChanged()
    }

}