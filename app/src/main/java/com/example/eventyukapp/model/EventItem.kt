package com.example.eventyukapp.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "events")
data class EventItem(
    @PrimaryKey val id: Int,
    val name: String,
    val location: String,
    val time: Long,
    val description: String,
    val longDescription: String,
    @DrawableRes val picture: Int,
    val mapsLink: String
) : Parcelable
