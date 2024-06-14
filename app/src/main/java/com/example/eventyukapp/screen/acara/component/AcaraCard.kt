package com.example.eventyukapp.screen.acara.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eventyukapp.R
import com.example.eventyukapp.model.EventItem
import com.example.eventyukapp.screen.beranda.ui.theme.EventYukAppTheme


@Composable
fun AcaraCard(
    event: EventItem,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(event.mapsLink) }
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp) // Half the height for the image
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFCFECF7))
            ) {
                Image(
                    painter = painterResource(id = event.picture),
                    contentDescription = event.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = event.name,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = event.location,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = event.description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
private fun EventCardPreview() {
    EventYukAppTheme {
        AcaraCard(
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
