package com.example.eventyukapp.repository

import com.example.eventyukapp.data.NotificationDao
import com.example.eventyukapp.model.NotificationItem

class NotificationRepository(private val notificationDao: NotificationDao) {
    suspend fun getAllNotifications(): List<NotificationItem> {
        return notificationDao.getAllNotifications()
    }

    suspend fun insertNotification(notification: NotificationItem) {
        notificationDao.insertNotification(notification)
    }
}