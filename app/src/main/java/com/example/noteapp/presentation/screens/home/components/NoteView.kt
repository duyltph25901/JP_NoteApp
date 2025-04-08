package com.example.noteapp.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.commons.DummyData.dummyNotes
import com.example.noteapp.model.entities.NoteEntity
import com.example.noteapp.ui.theme.NoteAppTheme

@Composable
fun NoteView(
    note: NoteEntity = NoteEntity(),
    index: Int = 0,
    onNoteClick: (note: NoteEntity) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(
                        size = 12.dp,
                    )
                ).background(
                    color = Color(
                        color = android.graphics.Color.parseColor("#FD99FF")
                    )
                ).clickable {
                    onNoteClick.invoke(note)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        vertical = 20.dp,
                        horizontal = 24.dp
                    ),
                text = note.title,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Start,
                maxLines = 3
            )
        }

        Spacer(
            modifier = Modifier.height(
                height = 24.dp
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewNoteView() {
    NoteAppTheme {
        NoteView(
            note = dummyNotes()[0],
            index = 0
        ) { }
    }
}