package com.example.eventyukapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.eventyukapp.model.NotificationItem

@Dao
interface NotificationDao {
    @Query("SELECT * FROM notifications")
    suspend fun getAllNotifications(): List<NotificationItem>

    @Insert
    suspend fun insertNotification(notification: NotificationItem)
}