package com.example.noteapp.presentation.screens.editor

import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.noteapp.R
import com.example.noteapp.commons.AppConst.BG_SCREEN
import com.example.noteapp.model.entities.NoteEntity
import com.example.noteapp.model.viewmodel.EditorViewModel

@Composable
fun EditorScreen(
    navController: NavController,
    viewModel: EditorViewModel,
    featureType: Int,
    jsonNoteEntity: String = ""
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .background(
                    color = Color(
                        color = android.graphics.Color.parseColor(BG_SCREEN)
                    )
                )
                .padding(
                    paddingValues = innerPadding
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        horizontal = 12.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.size(
                        size = 48.dp
                    ).clip(
                        shape = RoundedCornerShape(
                            size = 16.dp
                        )
                    ).background(
                        color = Color(
                            color = android.graphics.Color.parseColor("#3B3B3B")
                        )
                    ).clickable {
                        navController.popBackStack()
                    },
                    painter = painterResource(
                        id = R.drawable.img_back
                    ),
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.weight(
                        weight = 1f
                    )
                )

                Image(
                    modifier = Modifier.size(
                        size = 48.dp
                    ).clip(
                        shape = RoundedCornerShape(
                            size = 16.dp
                        )
                    ).background(
                        color = Color(
                            color = android.graphics.Color.parseColor("#3B3B3B")
                        )
                    ).clickable {
                        navController.popBackStack()
                    },
                    painter = painterResource(
                        id = R.drawable.img_preview
                    ),
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(
                        20.dp
                    ).height(
                        height = 12.dp
                    )
                )

                Image(
                    modifier = Modifier.size(
                        size = 48.dp
                    ).clip(
                        shape = RoundedCornerShape(
                            size = 16.dp
                        )
                    ).background(
                        color = Color(
                            color = android.graphics.Color.parseColor("#3B3B3B")
                        )
                    ).clickable {
                        saveRecord(
                            title = title,
                            description = description,
                            viewModel = viewModel
                        )
                        navController.popBackStack()
                    },
                    painter = painterResource(
                        id = R.drawable.img_save
                    ),
                    contentDescription = null
                )
            }

            Spacer(
                modifier = Modifier.height(
                    height = 24.dp
                )
            )

            Column(
                modifier = Modifier.weight(
                    weight = 1f
                ).verticalScroll(
                    state = scrollState
                )
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth()
                        .background(
                            color = Color(
                                color = android.graphics.Color.parseColor(BG_SCREEN)
                            )
                        ),
                    textStyle = TextStyle(
                        fontSize = 48.sp,
                        color = Color.White
                    ),
                    value = title,
                    onValueChange = { newValue ->
                        title = newValue
                    },
                    placeholder = {
                        Text(
                            text = "Title",
                            fontSize = 48.sp,
                            color = Color(
                                color = android.graphics.Color.parseColor("#9A9A9A")
                            )
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )

                Spacer(
                    modifier = Modifier.fillMaxSize()
                        .height(
                            height = 40.dp
                        )
                )

                TextField(
                    modifier = Modifier.fillMaxWidth()
                        .background(
                            color = Color(
                                color = android.graphics.Color.parseColor(BG_SCREEN)
                            )
                        ),
                    textStyle = TextStyle(
                        fontSize = 23.sp,
                        color = Color.White
                    ),
                    value = description,
                    onValueChange = { newValue ->
                        description = newValue
                    },
                    placeholder = {
                        Text(
                            text = "Type something....",
                            fontSize = 23.sp,
                            color = Color(
                                color = android.graphics.Color.parseColor("#9A9A9A")
                            )
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }
        }
    }
}

private fun saveRecord(
    title: String,
    description: String,
    viewModel: EditorViewModel
) = viewModel.saveNoteRecord(
    NoteEntity(
        title = title,
        description = description,
    )
)