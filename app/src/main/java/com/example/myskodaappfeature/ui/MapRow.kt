package com.example.myskodaappfeature.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myskodaappfeature.data.DrawablePair
import com.example.myskodaappfeature.data.tripsData
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

@Composable
fun MapItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
) {
    Surface (
        modifier = modifier,
        shadowElevation = MaulTheme.elevations.elevationXL,
        shape = RoundedCornerShape(10.dp),
        tonalElevation = MaulTheme.elevations.elevationXL
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxSize()
                    .shadow(elevation = MaulTheme.elevations.elevationXL, RoundedCornerShape(10.dp))
            )
            Text(
                text = stringResource(text),
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(MaulTheme.colors.warning)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }

}

@Composable
fun MapRow(
    tripsData: List<DrawablePair>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(20.dp)
    ) {
        items(tripsData) { item ->
            MapItem(drawable = item.drawable, text = item.text)
        }
    }
}