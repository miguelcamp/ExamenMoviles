package edu.bo.ucb.librosapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//titulo, isbn, autor, fecha publicacion, nro de paginas, descripcion breve, url foto portada
@Entity(tableName = "book_table")
class Book(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "isbn") var isbn : String,
    @ColumnInfo(name = "author") var author: String,
    @ColumnInfo(name = "publishDate")var publishDate: String,
    @ColumnInfo(name = "pages")var pages: Int,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "coverPageUrl") val coverPageUrl: String
) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Long = 0
}
