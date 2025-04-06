package com.example.noteapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTE_ENTITY")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String = "",
    val description: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = createdAt
) {
}