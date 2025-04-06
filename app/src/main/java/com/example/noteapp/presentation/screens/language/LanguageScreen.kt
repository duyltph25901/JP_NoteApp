package com.example.noteapp.presentation.screens.language

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteapp.R
import com.example.noteapp.commons.Nav.moveNextScreen
import com.example.noteapp.model.domain.LanguageDomain.Companion.getLanguages
import com.example.noteapp.presentation.nav.Routes
import com.example.noteapp.ui.theme.NoteAppTheme

@Composable
fun LanguageScreen(
    navController: NavController
) {
    var indexLanguageSelected by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(
                        id = R.string.language
                    ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                IconButton(
                    onClick = {
                        moveToOnbScreen(
                            navController = navController
                        )
                    }
                ) {
                    Image(
                        modifier = Modifier.size(
                            size = 20.dp
                        ),
                        painter = painterResource(
                            id = R.drawable.ic_tick
                        ),
                        contentDescription = null
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    height = 12.dp
                )
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    )
                    .weight(
                        weight = 1f
                    )
            ) {
                itemsIndexed(getLanguages()) { index, language ->
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .clip(
                                    shape = roundedCornerShapeItemLanguage()
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = roundedCornerShapeItemLanguage()
                                )
                                .clickable {
                                    indexLanguageSelected = index
                                },
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(
                                        all = 12.dp
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    modifier = Modifier.size(
                                        size = 32.dp
                                    ),
                                    painter = painterResource(
                                        id = language.icFlagRes
                                    ),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                                
                                Text(
                                    modifier = Modifier.weight(
                                        weight = 1f
                                    ).padding(
                                        horizontal = 12.dp
                                    ),
                                    text = language.languageName,
                                    fontSize = 12.sp,
                                )

                                val isAlreadySelected =
                                    (indexLanguageSelected == index)
                                if (isAlreadySelected) {
                                    Image(
                                        modifier = Modifier.size(
                                            16.dp
                                        ),
                                        painter = painterResource(
                                            id = R.drawable.ic_tick_circle
                                        ),
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                        Spacer(
                            modifier = Modifier.fillMaxSize()
                                .height(
                                    height = 8.dp
                                )
                        )
                    }
                }
            }
        }
    }
}

private fun roundedCornerShapeItemLanguage() =
    RoundedCornerShape(
        size = 20.dp
    )

private fun moveToOnbScreen(
    navController: NavController
) =
    moveNextScreen(
        navController = navController,
        targetRoute = Routes.OnbRoute.route,
        currentRoute = Routes.LanguageRoute.route,
        isFinish = true
    )

@Preview(showBackground = true)
@Composable
fun PreviewLanguageScreen() {
    NoteAppTheme {
        LanguageScreen(
            navController = NavController(
                context = LocalContext.current
            )
        )
    }
}