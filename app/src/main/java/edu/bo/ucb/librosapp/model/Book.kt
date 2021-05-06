package edu.bo.ucb.librosapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//titulo, isbn, autor, fecha publicacion, nro de paginas, descripcion breve, url foto portada
@Parcelize
@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,
    @ColumnInfo(name = "title")
    var title: String,
    var isbn : String,
    var author: String,
    var publishDate: String,
    var pages: Int,
    var description: String,
    var coverPageUrl: String
) : Parcelable
