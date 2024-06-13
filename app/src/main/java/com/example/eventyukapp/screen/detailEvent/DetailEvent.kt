package com.example.eventyukapp.screen.detailEvent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventyukapp.R
import com.example.eventyukapp.model.EventItem
import android.os.Parcelable
import androidx.compose.ui.platform.LocalContext
import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import kotlinx.parcelize.Parcelize
import com.example.eventyukapp.ui.theme.EventYukAppTheme
import androidx.compose.ui.text.font.FontWeight

class DetailEventActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val event = intent.getParcelableExtra<EventItem>("event")
        setContent {
            event?.let {
                EventDetailScreen(event, onBackPressed = { onBackPressedDispatcher.onBackPressed() })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(event: EventItem, onBackPressed: () -> Unit) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Detail Event",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 20.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )
                )
            },

            navigationIcon = {
                IconButton(onClick = onBackPressed) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFCFECF7)) // Light Sky Blue background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = event.picture),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = event.name,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = event.location, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = java.text.SimpleDateFormat("dd MMM yyyy, HH:mm", java.util.Locale.getDefault()).format(java.util.Date(event.time)),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = event.description, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = event.longDescription,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                textAlign = TextAlign.Justify,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(event.mapsLink))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)) // Button color
            ) {
                Text(text = "Open in Maps")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailPreview() {
    val event = EventItem(
        id = 1,
        name = "Konser Taylor Swift",
        location = "Stadion Gelora Bung Karno Jakarta",
        time = System.currentTimeMillis() + 86400000, // 1 day from now
        description = "Konser spektakuler oleh Taylor Swift",
        longDescription = "Bergabunglah dengan kami untuk sebuah malam yang penuh kesenangan dengan penampilan langsung oleh penyanyi terkenal Taylor Swift. Nikmati musik, tarian, dan kegembiraan sepanjang malam. Konser ini akan menampilkan sejumlah lagu hitsnya yang membuat Anda bergoyang dan bernyanyi sepanjang malam. Jangan lewatkan pengalaman yang tak terlupakan ini!",
        picture = R.drawable.img_poster_1,
        mapsLink = "https://www.google.com/maps/place/Stadion+Gelora+Bung+Karno"
    )

    EventYukAppTheme {
        EventDetailScreen(event = event, onBackPressed = {})
    }
}
