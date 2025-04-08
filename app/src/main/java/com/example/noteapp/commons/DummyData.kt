package com.example.noteapp.commons

import com.example.noteapp.model.entities.NoteEntity

object DummyData {

    fun dummyNotes() = listOf(
        NoteEntity(id = 0L, title = "UI concepts worth exsisting", description = "Description Dummy Note 1", createdAt = System.currentTimeMillis(), updatedAt = System.currentTimeMillis()),
        NoteEntity(id = 1L, title = "Book Review : The Design of Everyday Things by Don Norman", description = "Description Dummy Note 2", createdAt = System.currentTimeMillis(), updatedAt = System.currentTimeMillis()),
        NoteEntity(id = 2L, title = "Animes produced by Ufotable", description = "Description Dummy Note 3", createdAt = System.currentTimeMillis(), updatedAt = System.currentTimeMillis()),
        NoteEntity(id = 3L, title = "Mangas planned to read", description = "Description Dummy Note 4", createdAt = System.currentTimeMillis(), updatedAt = System.currentTimeMillis()),
        NoteEntity(id = 4L, title = "Awesome tweets collection", description = "Description Dummy Note 5", createdAt = System.currentTimeMillis(), updatedAt = System.currentTimeMillis()),
        NoteEntity(id = 5L, title = "List of free & open source apps", description = "Description Dummy Note 5", createdAt = System.currentTimeMillis(), updatedAt = System.currentTimeMillis()),
    )

}