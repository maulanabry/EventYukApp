package com.example.eventyukapp.screen.acara.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eventyukapp.R
import com.example.eventyukapp.model.EventItem
import com.example.eventyukapp.screen.beranda.ui.theme.EventYukAppTheme

@Composable
fun EventListItem(
    event: EventItem,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .clickable { onClick(event.mapsLink) }
        ) {
            Image(
                painter = painterResource(id = event.picture),
                contentDescription = event.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = event.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = event.location,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = event.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
private fun EventCardPreview() {
    EventYukAppTheme {
        EventListItem(
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
}
