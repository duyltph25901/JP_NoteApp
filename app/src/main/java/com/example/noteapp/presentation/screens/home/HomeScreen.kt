package com.example.noteapp.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.data.local.repository.NoteRepository
import com.example.noteapp.data.local.storage.note.NoteDao
import com.example.noteapp.model.viewmodel.HomeViewModel
import com.example.noteapp.ui.theme.NoteAppTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {

    val noteRecords by
        viewModel.listRecords.observeAsState(emptyList())

    LaunchedEffect(
        key1 = true
    ) {
        Log.d("duylt", "Size of array: ${noteRecords.size}")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                )
        ) {
            Text(
                text = "Home Screen"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    NoteAppTheme {
        HomeScreen(
            viewModel = hiltViewModel<HomeViewModel>()
        )
    }
}