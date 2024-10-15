package com.example.myskodaappfeature.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myskodaappfeature.R
import com.example.myskodaappfeature.data.DrawablePair
import com.example.myskodaappfeature.data.FeedInfo
import com.example.myskodaappfeature.data.feedData
import com.example.myskodaappfeature.data.tripsData
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

@Composable
fun FeedItem(
    feedInfo: FeedInfo,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier,
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(feedInfo.drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )
                Column (
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = feedInfo.name,
                        style = MaulTheme.typography.disclaimerBold
                    )
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.DirectionsCar,
                            modifier = modifier.size(25.dp),
                            tint = MaulTheme.colors.brandPrimary,
                            contentDescription = null
                        )
                        Text(
                            text = feedInfo.date,
                            style = MaulTheme.typography.disclaimer,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
            }
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                tint = MaulTheme.colors.brandPrimary,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceL))
        Text(
            text = feedInfo.header,
            style = MaulTheme.typography.header2,
            modifier = Modifier
                .paddingFromBaseline(bottom = MaulTheme.dimensions.spaceL)
                .padding(horizontal = 20.dp),
        )
        Row (
            modifier = Modifier.padding(horizontal = 20.dp)
        ){
            Row (
                modifier = Modifier.weight(1f)
            ) {
                Column {
                    Text(
                        text = "Distance",
                        style = MaulTheme.typography.disclaimer,
                        modifier = Modifier.paddingFromBaseline(bottom = MaulTheme.dimensions.spaceXXS)
                    )
                    Text(
                        text = "${feedInfo.distance} km",
                        style = MaulTheme.typography.header2,
                    )
                }
                Spacer(modifier = Modifier.width(MaulTheme.dimensions.spaceM))
                Column {
                    Text(
                        text = "Avg. speed",
                        style = MaulTheme.typography.disclaimer,
                        modifier = Modifier.paddingFromBaseline(bottom = MaulTheme.dimensions.spaceXXS)
                    )
                    Text(
                        text = "${feedInfo.speed} km/h",
                        style = MaulTheme.typography.header2,
                    )
                }
            }
            Column (
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Achievements",
                    style = MaulTheme.typography.disclaimer,
                )
                Row (
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.medal),
                        modifier = Modifier.size(25.dp),
                        tint = MaulTheme.colors.brandPrimary,
                        contentDescription = null
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.medal),
                        modifier = Modifier.size(25.dp),
                        tint = MaulTheme.colors.brandPrimary,
                        contentDescription = null
                    )
                    Text(
                        text = "2",
                        style = MaulTheme.typography.header1,
                        color = MaulTheme.colors.brandPrimary
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceXS))
        MapRow(feedInfo.maps)
    }
}

@Composable
fun FeedColumn(
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(feedData) { feedItem ->
            FeedItem(feedItem)
        }
    }
}



