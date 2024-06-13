package com.example.eventyukapp.navigation

sealed class Screen (val route: String){
    data object SplashScreen : Screen("splashscreen")
    data object OnBoarding : Screen("onboarding")
    data object Login : Screen("login")
    data object Beranda : Screen("beranda")
    data object Acara : Screen("acara")
    data object Notifikasi : Screen("notifikasi")
    data object DetailEvent : Screen("detailevent")
    data object Reminder : Screen("reminder")
}