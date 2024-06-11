package com.example.eventyukapp.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eventyukapp.R
import com.example.eventyukapp.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800)
        )
        delay(2000L)
        navController.navigate(Screen.OnBoarding.route) {
            popUpTo(Screen.SplashScreen.route) { inclusive = true }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0x212196F3) // Custom background color for the splash screen
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_eventyuk),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .scale(scale.value)
                    .size(200.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}