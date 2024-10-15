package com.example.myskodaappfeature.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vwg.skoda.maulcompose.lib.foundation.MaulTheme

@Composable
fun ExperienceBar(progress: Float, modifier: Modifier = Modifier) {
    Box(modifier) {
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
        Text(
            text = "${(progress * 100).toInt()}%",
            modifier = Modifier
                .padding(start = 10.dp),
            textAlign = TextAlign.Center,
            color = MaulTheme.colors.textPrimary,
            style = MaulTheme.typography.disclaimer,

        )
    }
}


@Preview(
    showBackground = true
)
@Composable
private fun ExperienceBarPreview() {
    ExperienceBar(progress = .25f)
}