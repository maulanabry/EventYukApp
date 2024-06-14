package com.example.eventyukapp.screen.beranda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.data.DummyData
import com.example.eventyukapp.model.EventItem
import com.example.eventyukapp.screen.acara.component.AcaraCard
import com.example.eventyukapp.screen.beranda.component.BannerSection
import com.example.eventyukapp.screen.beranda.component.RekomendasiCard
import com.example.eventyukapp.ui.theme.EventYukAppTheme

@Composable
fun BerandaScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val events = remember { DummyData.eventData }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top section with logo and title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
        }

        // Title below the logo

        // List of event cards in a grid
        BannerSection()
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding( vertical = 5.dp),
            text = "Rekomendasi",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Black,
            color = Color(0xFF2196F3)
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(events, key = { it.id }) { event ->
                RekomendasiCard(event = event) {
                    navController.navigate("detail/${event.id}")
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BerandaPreview() {
    EventYukAppTheme {
        BerandaScreen(navController = rememberNavController())
    }
}