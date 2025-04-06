package com.example.noteapp.presentation.screens.onb.components

import android.widget.ImageView.ScaleType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R
import com.example.noteapp.model.domain.OnbDomain
import com.example.noteapp.ui.theme.NoteAppTheme

@Composable
fun PageInformation(
    onbDomain: OnbDomain
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier.fillMaxWidth()
                .height(
                    height = 300.dp
                ),
            painter = painterResource(
                id = onbDomain.imgRes,
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.height(
                height = 20.dp
            )
        )

        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 12.dp
                ),
            text = stringResource(
                id = onbDomain.titleRes
            ),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier.height(
                height = 4.dp
            )
        )

        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                ),
            text = stringResource(
                id = onbDomain.desRes
            ),
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPageInformation() {
    NoteAppTheme {
        PageInformation(
            onbDomain = OnbDomain(
                id = 0L,
                titleRes = R.string.title_onb_1,
                desRes = R.string.des_onb_1,
                imgRes = R.drawable.img_onb_1
            )
        )
    }
}