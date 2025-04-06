package com.example.noteapp.data.local.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.data.local.storage.note.NoteDao
import com.example.noteapp.model.entities.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}