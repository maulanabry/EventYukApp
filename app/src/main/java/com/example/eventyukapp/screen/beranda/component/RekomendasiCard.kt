package com.example.eventyukapp.screen.beranda.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventyukapp.R
import com.example.eventyukapp.model.EventItem
import com.example.eventyukapp.screen.acara.component.AcaraCard

@Composable
fun RekomendasiCard(
    event: EventItem,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Box(
        modifier = modifier
            .requiredWidth(120.dp)
            .requiredHeight(187.dp)
            .clickable { onClick(event.mapsLink) }

    ) {
        Image(
            painter = painterResource(id = event.picture),
            contentDescription = "poster",
            modifier = Modifier
                .requiredWidth(120.dp)
                .requiredHeight(150.dp)
                .clip(RoundedCornerShape(15.dp))
                .align(Alignment.TopCenter)
        )
        Text(
            text = event.name,
            color = Color(0xff424242),
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp) // Adjust padding as needed
        )
    }
}

@Preview(widthDp = 120, heightDp = 187)
@Composable
private fun RekomendasiCardPreview() {
    RekomendasiCard(
        event = EventItem(
            id = 1,
            name = "Konser Taylor Swift",
            location = "Stadion Gelora Bung Karno Jakarta",
            time = System.currentTimeMillis() + 86400000, // 1 hari dari sekarang
            description = "Konser spektakuler oleh Taylor Swift",
            picture = R.drawable.img_poster_1,
            longDescription = "",
            mapsLink = "https://www.google.com/maps/place/Stadion+Gelora+Bung+Karno"
        ),
        onClick = { mapsLink ->
            // Implement the action you want to perform on click, e.g., opening Google Maps.
        }
    )
}