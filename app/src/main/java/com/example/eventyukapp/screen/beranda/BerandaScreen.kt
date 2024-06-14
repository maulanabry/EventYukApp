package com.example.eventyukapp.screen.beranda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.data.DummyData
import com.example.eventyukapp.screen.beranda.component.BannerSection
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
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventYukAppTheme {
        BerandaScreen(navController = rememberNavController())
    }
}