package edu.bo.ucb.librosapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//titulo, isbn, autor, fecha publicacion, nro de paginas, descripcion breve, url foto portada
@Entity(tableName = "book_table")
class Book(
    @ColumnInfo(name = "title")
    var title: String,
    var isbn : String,
    var author: String,
    var publishDate: String,
    var pages: Int,
    var description: String,
    val coverPageUrl: String
) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Long = 0
}
