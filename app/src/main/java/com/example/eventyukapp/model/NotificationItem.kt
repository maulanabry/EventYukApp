package com.example.eventyukapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class NotificationItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val time: Long
)