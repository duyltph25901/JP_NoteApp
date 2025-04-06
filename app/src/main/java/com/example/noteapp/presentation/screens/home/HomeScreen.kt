package com.example.noteapp.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.R
import com.example.noteapp.commons.AppConst.BG_SCREEN
import com.example.noteapp.data.local.repository.NoteRepository
import com.example.noteapp.data.local.storage.note.NoteDao
import com.example.noteapp.model.viewmodel.HomeViewModel
import com.example.noteapp.presentation.screens.home.components.HeaderHome
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
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(
                        color = android.graphics.Color.parseColor(BG_SCREEN)
                    )
                ).padding(
                    paddingValues = innerPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            HeaderHome(
                onEventSearch = {
                    Log.d("duylt", "Search Event")
                },
                onEventInformation = {
                    Log.d("duylt", "Information Event")
                }
            )

            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
                    .weight(
                        weight = 1f
                    ),
            ) {
                val btnAdd = createRef()

                Image(
                    modifier = Modifier.constrainAs(
                        ref = btnAdd
                    ) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }.padding(
                        end = 36.dp,
                        bottom = 48.dp
                    ).size(
                        size = 80.dp
                    ).clickable {

                    },
                    painter = painterResource(
                        id = R.drawable.ic_add_circle
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
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