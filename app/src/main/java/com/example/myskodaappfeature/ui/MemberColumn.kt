package com.example.myskodaappfeature.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myskodaappfeature.R
import com.example.myskodaappfeature.data.Member
import com.example.myskodaappfeature.data.memberData
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

@Composable
fun MemberColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, MaulTheme.colors.textTertiary, RoundedCornerShape(10.dp))
    ) {
        memberData.forEach { member ->
            Column {
                MemberItem(member = member)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaulTheme.colors.textTertiary
                )
            }
        }
        MemberAdd()
    }
}


@Composable
fun MemberAdd(modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier
            .padding(10.dp),
        color = MaulTheme.colors.backgroundPrimary,
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box (
                    modifier = Modifier.size(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = MaulTheme.colors.brandPrimary,
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(2.dp, MaulTheme.colors.brandPrimary, CircleShape)
                            .fillMaxSize()
                            .padding(6.dp),
                    )
                }
                Text(
                    text = "Invite a member",
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    style = MaulTheme.typography.disclaimer.copy(
                        fontSize = MaulTheme.typography.header4.fontSize
                    )
                )
            }

        }
    }
}

@Composable
fun MemberItem(
    member: Member,
    modifier: Modifier = Modifier
) {
    Surface (
        modifier = modifier
            .padding(10.dp),
        color = MaulTheme.colors.backgroundPrimary,
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(member.drawable),
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(1.dp, MaulTheme.colors.brandPrimary, CircleShape)
                        .size(45.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
                Text(
                    text = member.name,
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    style = MaulTheme.typography.disclaimer.copy(
                        fontSize = MaulTheme.typography.header4.fontSize
                    )
                )
            }
            Column {
                Text(
                    text = "${member.dist} km",
                    style = MaulTheme.typography.disclaimerBold
                )
                Text(
                    text = "${member.time} h",
                    style = MaulTheme.typography.disclaimerBold
                )
            }

        }
    }
}

@Preview (
    showBackground = true,
    widthDp = 300
)
@Composable
fun MemberColumnPreview() {
    MemberColumn()
}


