package com.example.noteapp.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.commons.AppConst.BG_SCREEN
import com.example.noteapp.commons.DummyData.dummyNotes
import com.example.noteapp.model.entities.NoteEntity
import com.example.noteapp.ui.theme.NoteAppTheme

@Composable
fun NotesView(
    notes: List<NoteEntity> = emptyList(),
    onNoteClicked: (note: NoteEntity) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(
                horizontal = 16.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.height(
                height = 24.dp
            )
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .background(
                    color = Color(
                        color = android.graphics.Color.parseColor(BG_SCREEN)
                    )
                )
        ) {
            itemsIndexed(
                items = notes,
                key = { _, note ->
                    note.toString()
                }
            ) { index, note ->
                NoteView(
                    note = note,
                    onNoteClick = { noteClicked ->
                        onNoteClicked.invoke(noteClicked)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNotesView() {
    NoteAppTheme {
        NotesView(
            notes = dummyNotes()
        ) {}
    }
}