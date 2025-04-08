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
class EditorViewModel @Inject constructor(
    private val noteRepo: NoteRepository
): ViewModel() {

    fun saveNoteRecord(note: NoteEntity) =
        viewModelScope.launch(
            Dispatchers.IO + Job()
        ) {
            noteRepo.saveNoteRecord(
                noteEntity = note
            )
        }

    fun updateNoteRecord(note: NoteEntity) =
        viewModelScope.launch(
            Dispatchers.IO + Job()
        ) {
            noteRepo.updateNoteRecord(
                noteEntity = note
            )
        }

}