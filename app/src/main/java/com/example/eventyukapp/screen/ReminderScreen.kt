package com.example.eventyukapp.screen

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.eventyukapp.data.AppDatabase
import com.example.eventyukapp.model.EventItem
import com.example.eventyukapp.model.NotificationItem
import com.example.eventyukapp.navigation.Screen
import com.example.eventyukapp.repository.NotificationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.util.Log

@Composable
fun ReminderScreen(onReminderSet: (String, Long) -> Unit, navController: NavHostController) {
    val context = LocalContext.current
    var eventName by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var eventTime by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }

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
                title = { Text("Set Reminder",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
                        try {
                            val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())
                            val eventDateTime = "$eventDate $eventTime"
                            val eventMillis = formatter.parse(eventDateTime)?.time ?: 0L

                            if (eventMillis > 0L) {
                                onReminderSet(eventName, eventMillis)
                                addNotificationToDatabase(context, eventName, eventMillis)
                                showSuccessDialog = true
                            } else {
                                Log.e("ReminderScreen", "Invalid date/time format")
                            }
                        } catch (e: Exception) {
                            Log.e("ReminderScreen", "Error setting reminder", e)
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

    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = { showSuccessDialog = false },
            title = { Text("Sukses") },
            text = { Text("Pengingat berhasil ditambahkan!") },
            confirmButton = {
                Button(
                    onClick = {
                        showSuccessDialog = false
                        navController.navigate(Screen.Notifikasi.route) // Navigate to NotificationScreen
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3),
                        contentColor = Color.White
                    )
                ) {
                    Text("OK")
                }
            }
        )
    }
}

fun addNotificationToDatabase(context: Context, name: String, timeInMillis: Long) {
    val notificationDao = AppDatabase.getInstance(context).notificationDao()
    val notificationRepository = NotificationRepository(notificationDao)
    val notificationItem = NotificationItem(name = name, time = timeInMillis)

    CoroutineScope(Dispatchers.IO).launch {
        try {
            notificationRepository.insertNotification(notificationItem)
            Log.d("Database", "Notification added successfully")
        } catch (e: Exception) {
            Log.e("Database", "Error adding notification to database", e)
        }
    }
}