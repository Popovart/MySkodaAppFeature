package com.example.myskodaappfeature.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myskodaappfeature.data.achievementsData
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

@Composable
fun AchievementsRow(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(achievementsData) { item ->
            AchievementsItem(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun AchievementsItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.width(95.dp)
    ) {
        Surface (
            shadowElevation = 10.dp,
            shape = CircleShape,
            modifier = Modifier.size(80.dp),
            color = MaulTheme.colors.backgroundSecondary
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(10.dp)

            )
        }

        Text(
            text = stringResource(text),
            style = MaulTheme.typography.disclaimerBold,
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}