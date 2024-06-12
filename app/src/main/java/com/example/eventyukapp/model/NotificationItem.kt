package com.example.eventyukapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class NotificationItem(
    @PrimaryKey val id: Int,
    val eventId: Int,
    val userId: Int,
    val notificationTime: Long
)
