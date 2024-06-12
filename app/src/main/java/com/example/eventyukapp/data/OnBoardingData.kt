package com.example.eventyukapp.data

import com.example.eventyukapp.R
import com.example.eventyukapp.model.OnBoardingItem

object OnBoardingData {
    val onBoardingItems = listOf(
        OnBoardingItem(
            resId = R.raw.onboardingeventyuk1,
            title = "Temukan Event Sesuai Seleramu",
            description = "Temukan event sesuai seleramu kapanpun dan dimanapun."
        ),
        OnBoardingItem(
            resId = R.raw.onboardingeventyuk2,
            title = "Kumpulan Event Seru Yang Menantimu",
            description = "Hari Berwarna dengan Event Yuk!"
        ),
    )
}