package com.example.myskodaappfeature.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.myskodaappfeature.R

data class DrawablePair (
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

data class FeedInfo (
    val name: String,
    val date: String,
    val header: String,
    val distance: Double,
    val speed: Double,
    val maps: List<DrawablePair>,
)


val achievementsData = listOf(
    R.drawable.safety to R.string.safe_zone_driver,
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
).map { DrawablePair(it.first, it.second) }

val tripsData = listOf(
    R.drawable.map1 to R.string.trip,
    R.drawable.map1 to R.string.trip,
).map { DrawablePair(it.first, it.second) }

val feedData = listOf(
    FeedInfo(
        name = "Afanaso Valerii",
        date = "Yesterday at 9:59 Prague",
        header = "My holiday trip with family",
        distance = 21.71,
        speed = 70.4,
        maps = tripsData
    ),
    FeedInfo(
        name = "Fafanaso Valerii",
        date = "Yesterday at 9:59 Prague",
        header = "My holiday trip with family",
        distance = 21.71,
        speed = 70.4,
        maps = tripsData
    )
)