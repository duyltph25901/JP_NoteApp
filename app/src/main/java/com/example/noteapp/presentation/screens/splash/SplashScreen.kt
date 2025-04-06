package com.example.noteapp.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteapp.R
import com.example.noteapp.commons.AppConst.TIME_DELAY_SPLASH
import com.example.noteapp.commons.Nav.moveNextScreen
import com.example.noteapp.presentation.nav.Routes
import com.example.noteapp.ui.theme.NoteAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {

    LaunchedEffect(Unit) {
        delay(TIME_DELAY_SPLASH)
        moveToLanguageScreen(navController)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(
                modifier = Modifier.weight(
                    weight = 1f
                )
            )

            Image(
                modifier = Modifier.size(
                    size = 120.dp
                ),
                painter = painterResource(
                    id = R.drawable.logo_app
                ),
                contentDescription = null
            )

            Spacer(
                modifier = Modifier.weight(
                    weight = 1f
                )
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    ),
                text = stringResource(
                    id = R.string.splash_des
                ),
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(
                    height = 24.dp
                )
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    NoteAppTheme {
        SplashScreen(
            navController = NavController(
                context = LocalContext.current
            )
        )
    }
}

private fun moveToLanguageScreen(navController: NavController) =
    moveNextScreen(
        navController = navController,
        targetRoute = Routes.LanguageRoute.route,
        currentRoute = Routes.SplashRoute.route,
        isFinish = true
    )