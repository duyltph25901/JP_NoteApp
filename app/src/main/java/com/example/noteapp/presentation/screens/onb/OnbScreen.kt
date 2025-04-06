package com.example.noteapp.presentation.screens.onb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteapp.R
import com.example.noteapp.commons.Nav.moveNextScreen
import com.example.noteapp.model.domain.OnbDomain.Companion.getOnbs
import com.example.noteapp.presentation.nav.Routes
import com.example.noteapp.presentation.screens.onb.components.PageIndicator
import com.example.noteapp.presentation.screens.onb.components.PageInformation
import com.example.noteapp.ui.theme.NoteAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnbScreen(
    navController: NavController
) {
    val pagerState = rememberPagerState(
        pageCount = getOnbs().size
    )
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(
                    paddingValues = innerPadding
                )
        ) {
            HorizontalPager(
                modifier = Modifier.weight(
                    weight = 1f
                ),
                state = pagerState,
            ) { indexPageCurrent ->
                val onbDomain =
                    getOnbs()[indexPageCurrent]
                PageInformation(
                    onbDomain = onbDomain
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PageIndicator(
                    size = getOnbs().size,
                    indexCurrent = pagerState.currentPage,
                )

                val isLastPage =
                    (pagerState.currentPage == getOnbs().size - 1)
                TextButton (
                    onClick = {
                        nextPage(
                            navController = navController,
                            size = getOnbs().size,
                            current = pagerState.currentPage,
                            pagerState = pagerState,
                            scope = scope,
                        )
                    }
                ) {
                    Text(
                        text = stringResource(
                            id = if (isLastPage) R.string.get_started
                            else R.string.next
                        ),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    height = 16.dp
                )
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
private fun nextPage(
    navController: NavController,
    size: Int,
    current: Int,
    pagerState: PagerState,
    scope: CoroutineScope
) {
    val isFeatureMoveScreen =
        current >= size - 1

    if (isFeatureMoveScreen) {
        moveToHomeScreen(
            navController = navController
        )
    } else nextPage(
        scope = scope,
        pagerState = pagerState,
        current = current
    )
}

private fun moveToHomeScreen(
    navController: NavController
) {
    moveNextScreen(
        navController = navController,
        targetRoute = Routes.HomeRoute.route,
        currentRoute = Routes.OnbRoute.route,
        isFinish = true
    )
}

@OptIn(ExperimentalPagerApi::class)
private fun nextPage(
    scope: CoroutineScope,
    pagerState: PagerState,
    current: Int
) = scope.launch {
    pagerState.animateScrollToPage(
        page = current + 1
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewOnbScreen() {
    NoteAppTheme {
        OnbScreen(
            navController = NavController(
                context = LocalContext.current
            )
        )
    }
}