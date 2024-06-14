package com.example.eventyukapp.screen.beranda.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.eventyukapp.R


@Composable
fun BannerSection(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(height = 160.dp)  // Adjusted height for better spacing
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color(0xFFEFF3FB))
            .padding(16.dp)  // Increased padding for better layout
    ) {
        Box(
            modifier = Modifier
                .requiredSize(size = 130.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_eventitl3),
                contentDescription = "puppet",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .clip(RoundedCornerShape(8.dp))
                    .requiredSize(120.dp)  // Adjusted size for better alignment
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)  // Increased padding for better layout
        ) {
            Text(
                text = "Temukan Event Menarik",
                color = Color.Black,
                lineHeight = 1.5.em,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,  // Ensures the text is in one line
                overflow = TextOverflow.Ellipsis,  // Adds ellipsis if the text is too long
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .padding(bottom = 4.dp)  // Padding between title and description
            )
            Text(
                text = "Bersenang-senang bersama teman-teman kamu!",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
    }
}

@Preview(widthDp = 322, heightDp = 140)
@Composable
private fun BannerSectionPreview() {
    BannerSection(Modifier)
}