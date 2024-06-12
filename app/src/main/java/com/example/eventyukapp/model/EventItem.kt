package com.example.eventyukapp.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "events")
data class EventItem(
    @PrimaryKey val id: Int,
    val name: String,
    val location: String,
    val time: Long,
    val description: String,
    val longDescription: String, // Tambah properti longDescription di sini
    @DrawableRes val picture: Int,
    val mapsLink: String
)
