package com.example.noteapp.data.local.storage.note

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.model.entities.NoteEntity

@Dao
interface NoteDao {

    @Insert(
        entity = NoteEntity::class,
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun saveNoteRecord(
        note: NoteEntity
    )

    @Update(
        entity = NoteEntity::class,
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun updateNoteRecord(
        note: NoteEntity
    )

    @Delete(
        entity = NoteEntity::class,
    )
    suspend fun deleteNoteRecord(
        note: NoteEntity
    )

    @Query("SELECT * FROM NOTE_ENTITY ORDER BY `createdAt` DESC")
    fun getAllNoteRecords(): LiveData<List<NoteEntity>>

}