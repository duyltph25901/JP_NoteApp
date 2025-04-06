package com.example.noteapp.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R


internal const val FLAG_EVENT_SEARCH = 1
internal const val FLAG_EVENT_INFORMATION = -1

@Composable
fun HeaderHome(
    onEventSearch: () -> Unit,
    onEventInformation: () -> Unit
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
                id = R.string.notes
            ),
            color = Color.White,
            fontSize = 44.sp
        )

        Row {
            IconButtonHeader(
                flagEvent = FLAG_EVENT_SEARCH,
                eventClick = {
                    onEventSearch.invoke()
                }
            )

            Spacer(
                modifier = Modifier.width(
                    width = 20.dp
                )
            )

            IconButtonHeader(
                flagEvent = FLAG_EVENT_INFORMATION,
                eventClick = {
                    onEventInformation.invoke()
                }
            )
        }
    }
}

@Composable
private fun IconButtonHeader(
    flagEvent: Int,
    eventClick: () -> Unit
) {
    IconButton(
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                size = 16.dp
            )
        ).background(
            color = Color(
                color = android.graphics.Color.parseColor("#3B3B3B")
            )
        ),
        onClick = {
            eventClick.invoke()
        }
    ) {
        Image(
            modifier = Modifier.size(
                size = 24.dp
            ),
            painter = painterResource(
                id = when (flagEvent) {
                    FLAG_EVENT_SEARCH -> R.drawable.ic_search
                    else -> R.drawable.ic_information
                }
            ),
            contentDescription = null
        )
    }
}