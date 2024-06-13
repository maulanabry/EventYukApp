package com.example.eventyukapp.screen.beranda

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.R
import com.example.eventyukapp.data.DummyData
import com.example.eventyukapp.model.EventItem
import com.example.eventyukapp.navigation.Screen
import com.example.eventyukapp.screen.beranda.component.EventCard
import com.example.eventyukapp.screen.detailEvent.DetailEventActivity
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
        Text(
            text = "Acara",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )


        // List of event cards in a grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(events, key = { it.id }) { event ->
                EventCard(event = event) {
                    navController.navigate("${Screen.EventDetail.route}/${event.id}")
                }
            }
        }
    }
}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventYukAppTheme {
        BerandaScreen(navController = rememberNavController())
    }
}