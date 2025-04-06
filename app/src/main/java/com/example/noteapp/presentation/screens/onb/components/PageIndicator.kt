package com.example.noteapp.presentation.screens.onb.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.ui.theme.NoteAppTheme

@Composable
fun PageIndicator(
    size: Int,
    indexCurrent: Int,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(size) { index ->
            DotIndicator(
                isSelected = (indexCurrent == index)
            )

            val isLastItem = index == size - 1
            if (isLastItem.not()) {
                Spacer(
                    modifier = Modifier.width(
                        width = 4.dp
                    )
                )
            }
        }
    }

}

@Composable
fun DotIndicator(isSelected: Boolean) {
    val widthDotSelected = animateDpAsState(
        targetValue = if (isSelected) 28.dp else 12.dp,
        label = ""
    )

    Box(
        modifier = Modifier.height(
            height = 12.dp
        ).width(
            width = widthDotSelected.value
        ).clip(
            shape = CircleShape
        ).background(
            color = Color.Black
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewOnbIndicator() {
    NoteAppTheme {
        PageIndicator(
            size = 3,
            indexCurrent = 1
        )
    }
}