package com.example.noteapp.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R
import com.example.noteapp.commons.AppConst.BG_SCREEN
import com.example.noteapp.ui.theme.NoteAppTheme

@Composable
fun EmptyNotes() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(
                320.dp
            ),
            painter = painterResource(
                id = R.drawable.img_empty_notes
            ),
            contentDescription = null
        )

        Text(
            text = stringResource(
                id = R.string.empty_notes
            ),
            fontSize = 20.sp,
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmptyNotes() {
    NoteAppTheme {
        EmptyNotes()
    }
}