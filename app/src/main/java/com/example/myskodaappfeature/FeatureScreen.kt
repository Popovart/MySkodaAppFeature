package com.example.myskodaappfeature

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myskodaappfeature.ui.FeedColumn
import com.example.myskodaappfeature.ui.FriendsScreen
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

enum class FeatureScreen(@StringRes val title: Int)
{
    Community(title = R.string.community),
    Family(title = R.string.family)
}

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

        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
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
                            maxLines = 1,
                            style = MaulTheme.typography.disclaimer
                        )
                    },
                )
            }
        }
    }
}



@Composable
fun FeatureSection(
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

@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        FeedColumn()
        Spacer(modifier = Modifier.height(MaulTheme.dimensions.spaceM))
    }
}

@Composable
fun FeatureAppBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val tabs = listOf(FeatureScreen.Community.name, FeatureScreen.Family.name)
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column (modifier) {
        Text(
            text = "Social",
            style = MaulTheme.typography.header2,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 10.dp, end = 20.dp)
        )
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaulTheme.colors.backgroundPrimary,
            contentColor = MaulTheme.colors.neutralPrimary,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = MaulTheme.colors.brandPrimary
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        navController.navigate(title)
                    },
                    text = {
                        Text(
                            text = title,
                            color = if (selectedTabIndex == index)
                                MaulTheme.colors.textPrimary
                            else
                                MaulTheme.colors.textTertiary,
                            style = MaulTheme.typography.disclaimerBold.copy(
                                fontSize = MaulTheme.typography.header4.fontSize
                            )
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold (
        topBar = {
            FeatureAppBar(navController = navController)
        },
        floatingActionButton = {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(CircleShape)
                    .size(70.dp)
                    .background(
                        MaulTheme.colors.brandPrimary
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(.6f),
                    tint = MaulTheme.colors.brandTertiary
                )
            }
        },
        bottomBar = {
            SootheBottomNavigation()
        },
        containerColor = MaulTheme.colors.backgroundPrimary
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = FeatureScreen.Community.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = FeatureScreen.Community.name) {
                FeedScreen()
            }
            composable(route = FeatureScreen.Family.name) {
                FriendsScreen()
            }
        }
    }
}

@Preview
@Composable
private fun FeatureScreenPreview() {
    FeatureScreen()
}