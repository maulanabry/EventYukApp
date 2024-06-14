package com.example.eventyukapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventyukapp.model.NotificationItem
import com.example.eventyukapp.repository.NotificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotificationViewModel(private val repository: NotificationRepository) : ViewModel() {
    private val _notifications = MutableStateFlow<List<NotificationItem>>(emptyList())
    val notifications: StateFlow<List<NotificationItem>> get() = _notifications

    fun getNotifications() {
        viewModelScope.launch {
            _notifications.value = repository.getAllNotifications()
        }
    }
}
