package com.example.myskodaappfeature.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myskodaappfeature.FeatureSection
import com.example.myskodaappfeature.R
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

@Composable
fun FriendsScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        contentPadding = PaddingValues(bottom = MaulTheme.dimensions.spaceM)
    ) {
        item {
            PersonalCard()
            Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceM))
            FeatureSection(
                title = "Last achievements:",
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                AchievementsRow()
            }
        }

        // Раздел с участниками
        item {
            FeatureSection(
                title = "Members",
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                MemberColumn(modifier = Modifier.padding(horizontal = 20.dp))
            }
            Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceM))
        }
    }
}


@Composable
fun PersonalCard(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.vafanaso),
                modifier = Modifier
                    .clip(CircleShape)
                    .border(3.dp, MaulTheme.colors.brandPrimary, CircleShape)
                    .size(200.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            Text(
                text = "Oleksandr Romashko",
                modifier = Modifier.paddingFromBaseline(
                    top = MaulTheme.dimensions.spaceXL,
                    bottom = MaulTheme.dimensions.spaceM,
                ),
                style = MaulTheme.typography.header2,
                textAlign = TextAlign.Center
            )
        }
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(.8f)
        ) {
            Text(
                text = "05",
                modifier = Modifier
                    .padding(start = 5.dp),
                style = MaulTheme.typography.header2,
            )
            ExperienceBar(
                progress = .3f,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    }
}

@Preview (
    showBackground = true
)
@Composable
private fun FriendsScreenPreview() {
    FriendsScreen()
}