package com.example.eventyukapp.screen

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.TimePickerDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.R
import com.example.eventyukapp.model.EventItem
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EventDetailScreen(event: EventItem, onBackPressed: () -> Unit, navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(event.name) },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = Color.White
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Detail Event: ${event.name}")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("reminder") }) {
                    Text("Set Reminder")
                }
            }
        }
    )
}

@Composable
fun ReminderScreen(onReminderSet: (String, Long) -> Unit) {
    val context = LocalContext.current
    var eventName by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var eventTime by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            eventDate = dateFormat.format(calendar.time)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    val timePickerDialog = TimePickerDialog(
        context,
        { _, hourOfDay, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar.set(Calendar.MINUTE, minute)
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            eventTime = timeFormat.format(calendar.time)
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        true
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Set Reminder") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = Color.White
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = eventName,
                    onValueChange = { eventName = it },
                    label = { Text("Nama Acara") }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { datePickerDialog.show() },
                    value = eventDate,
                    onValueChange = { eventDate = it },
                    label = { Text("Tanggal") },
                    trailingIcon = {
                        IconButton(onClick = { datePickerDialog.show() }) {
                            Icon(Icons.Filled.DateRange, contentDescription = "Pilih tanggal")
                        }
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { timePickerDialog.show() },
                    value = eventTime,
                    onValueChange = { eventTime = it },
                    label = { Text("Waktu") },
                    trailingIcon = {
                        IconButton(onClick = { timePickerDialog.show() }) {
                            Icon(Icons.Filled.AddCircle, contentDescription = "Pilih waktu")
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())
                        val eventDateTime = "$eventDate $eventTime"
                        val eventMillis = formatter.parse(eventDateTime)?.time ?: 0L

                        if (eventMillis > 0L) {
                            onReminderSet(eventName, eventMillis)
                        } else {
                            // Handle invalid date/time format
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3),
                        contentColor = Color.White
                    )
                ) {
                    Text("Set Reminder")
                }
            }
        }
    }
}

class AlarmReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        val eventName = intent.getStringExtra("EVENT_NAME")
        // Show notification or handle the alarm event
        createNotification(context, eventName)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun createNotification(context: Context, eventName: String?) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val notificationChannel = NotificationChannel(
        "EVENT_REMINDER_CHANNEL",
        "Event Reminder",
        NotificationManager.IMPORTANCE_HIGH
    )
    notificationManager.createNotificationChannel(notificationChannel)

    val notification = NotificationCompat.Builder(context, "EVENT_REMINDER_CHANNEL")
        .setContentTitle("Event Reminder")
        .setContentText("Don't forget: $eventName")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()

    notificationManager.notify(0, notification)
}

@Preview(showBackground = true)
@Composable
fun ReminderScreenPreview() {
    ReminderScreen { _, _ -> }
}

// Activity setup
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val event = intent.getParcelableExtra<EventItem>("event")
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "detail") {
                composable("detail") {
                    event?.let {
                        EventDetailScreen(event, onBackPressed = { onBackPressedDispatcher.onBackPressed() }, navController)
                    }
                }
                composable("reminder") {
                    ReminderScreen(onReminderSet = { eventName, eventMillis ->
                        // Handle reminder set logic here
                    })
                }
            }
        }
    }
}
