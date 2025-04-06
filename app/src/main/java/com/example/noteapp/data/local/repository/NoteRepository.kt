package com.example.noteapp.data.local.repository

import com.example.noteapp.data.local.storage.note.NoteDao
import com.example.noteapp.model.entities.NoteEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    fun getAllNoteRecords() =
        noteDao.getAllNoteRecords()

    suspend fun saveNoteRecord(
        noteEntity: NoteEntity
    ) = noteDao.saveNoteRecord(
        note = noteEntity
    )

    suspend fun updateNoteRecord(
        noteEntity: NoteEntity
    ) = noteDao.updateNoteRecord(
        note = noteEntity
    )

    suspend fun deleteNoteRecord(
        noteEntity: NoteEntity
    ) = noteDao.deleteNoteRecord(
        note = noteEntity
    )

}