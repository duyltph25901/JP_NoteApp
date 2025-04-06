package com.example.noteapp.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.local.repository.NoteRepository
import com.example.noteapp.model.entities.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class HomeViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val listRecords = noteRepository.getAllNoteRecords()

    fun deleteNoteRecord(
        noteEntity: NoteEntity
    ) = viewModelScope.launch(
        Dispatchers.IO + Job()
    ) {
        noteRepository.deleteNoteRecord(
            noteEntity = noteEntity
        )
    }

}