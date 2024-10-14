package com.example.myskodaappfeature

import android.content.res.Configuration
import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ehsanmsz.mszprogressindicator.progressindicator.LineScaleProgressIndicator
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

@Composable
fun SootheBottomNavigation(
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableIntStateOf(4) }
    NavigationBar (
        containerColor = MaulTheme.colors.backgroundPrimary,
        modifier = modifier
            .drawWithContent {
                drawContent()
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 0.5.dp.toPx()
                )
            }
    ) {
        val items = listOf("Car", "Maps", "Inspect", "Discover", "Social", "Profile")
        val icons = listOf(
            Icons.Default.DirectionsCar,
            Icons.Default.PinDrop,
            Icons.Default.MonitorHeart,
            Icons.Default.Newspaper,
            Icons.Default.FamilyRestroom,
            Icons.Default.SupervisorAccount
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaulTheme.colors.brandPrimary,
                    selectedTextColor = MaulTheme.colors.brandPrimary,
                    indicatorColor = MaulTheme.colors.backgroundPrimary
                ),
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = item,
                        style = MaulTheme.typography.disclaimer
                    )
                },
            )
        }
    }
}


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
                text = "Trip",
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
            modifier = Modifier.size(80.dp)
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
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

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
fun ExperienceBar(progress: Float, modifier: Modifier) {

    Column (modifier) {
        Surface (
            tonalElevation = 10.dp,
            shadowElevation = MaulTheme.elevations.elevationXL,
            shape = MaterialTheme.shapes.large
        ) {
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp),
                color = MaulTheme.colors.brandPrimary,
                trackColor = MaulTheme.colors.backgroundSecondary,
                strokeCap = StrokeCap.Round
            )
        }
        Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceS))

        Surface (
            tonalElevation = 10.dp,
            shadowElevation = MaulTheme.elevations.elevationXL,
            color = MaulTheme.colors.backgroundSecondary
        ) {
            LineScaleProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaulTheme.colors.brandPrimary,
                lineCount = 20,
                minLineHeight = 20.dp
            )
        }

        Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceS))

        Surface (
            tonalElevation = 10.dp,
            shadowElevation = MaulTheme.elevations.elevationXL,
            color = MaulTheme.colors.backgroundSecondary
        ) {
            LineScaleProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaulTheme.colors.brandPrimary,
                lineCount = 20,
                minLineHeight = 20.dp,
                animationDelay = 3000
            )
        }
        
    }
}

@Composable
fun Feed(modifier: Modifier = Modifier) {
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
                    painter = painterResource(R.drawable.vafanaso),
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
                        text = "Afanaso Valerii",
                        style = MaulTheme.typography.disclaimerBold
                    )
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.DirectionsCar,
                            modifier = modifier.size(25.dp),
                            contentDescription = null
                        )
                        Text(
                            text = "Yesterday at 9:59 Prague",
                            style = MaulTheme.typography.disclaimer,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
            }
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceL))
        Text(
            text = "My holiday trip with family",
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
                        text = "21,71 km",
                        style = MaulTheme.typography.header2,
                    )
                }
                Spacer(modifier = Modifier.width(MaulTheme.dimensions.spaceM))
                Column {
                    Text(
                        text = "Evg. speed",
                        style = MaulTheme.typography.disclaimer,
                        modifier = Modifier.paddingFromBaseline(bottom = MaulTheme.dimensions.spaceXXS)
                    )
                    Text(
                        text = "70.4 km",
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
        MapRow()
    }
}

@Composable
fun SocialSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Text(
        text = title,
        style = MaulTheme.typography.header3,
        modifier = modifier.paddingFromBaseline(bottom = MaulTheme.dimensions.spaceM)
    )
    content()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureScreen() {
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(vertical = 15.dp),
                colors = topAppBarColors(
                    containerColor = MaulTheme.colors.backgroundPrimary,
                ),
                title = {
                    Text(
                        text = "Social",
                        style = MaulTheme.typography.header1
                    )
                }
            )
        },
        bottomBar = {
            SootheBottomNavigation()
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            SocialSection(
                title = "Your progress:",
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                ExperienceBar(
                    progress = .3f,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceM))
            SocialSection(
                title = "Last achievements:",
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                AchievementsRow()
            }
            Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceXXS))
            SocialSection(
                title = "Feed:",
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Feed()
            }
            Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceM))
        }
    }
}

data class DrawablePair (
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val achievementsData = listOf(
    R.drawable.safety to R.string.night_ranger,

    R.drawable.travel to R.string.traveler,
    R.drawable.renewable_energy to R.string.silent_hero,
    R.drawable.remote to R.string.remote_control_master,
    R.drawable.driving to R.string.time_behind_the_wheel,
    R.drawable.eco_friendly to R.string.eco_driver,
    R.drawable.parking to R.string.parking_master,
    R.drawable.eco_friendly2 to R.string.green_circle,
    R.drawable.proactive to R.string.ticket_free_driver,
    R.drawable.tools to R.string.diagnosed_and_confirmed,
    R.drawable.car to R.string.night_ranger,
    R.drawable.on_time to R.string.on_time
).map {DrawablePair(it.first, it.second)}

private val tripsData = listOf(
    R.drawable.map1 to R.string.trip,
    R.drawable.map1 to R.string.trip,
).map {DrawablePair(it.first, it.second)}

@Preview
@Composable
private fun FeatureScreenPreview() {
    FeatureScreen()
}