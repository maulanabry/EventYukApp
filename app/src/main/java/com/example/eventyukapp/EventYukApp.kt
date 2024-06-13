package com.example.eventyukapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.navigation.NavigationItem
import com.example.eventyukapp.navigation.Screen
import com.example.eventyukapp.screen.OnBoardingScreen
import com.example.eventyukapp.screen.SplashScreen
import com.example.eventyukapp.screen.LoginScreen
import com.example.eventyukapp.screen.beranda.BerandaScreen
import com.example.eventyukapp.screen.detailEvent.DetailEventScreen
import com.example.eventyukapp.screen.ReminderScreen
import com.example.eventyukapp.ui.theme.EventYukAppTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.screen.OnBoardingScreen
import com.example.eventyukapp.screen.SplashScreen
import androidx.compose.foundation.layout.fillMaxSize
import com.example.eventyukapp.screen.LoginScreen
import com.example.eventyukapp.screen.beranda.BerandaScreen
import com.example.eventyukapp.screen.detailEvent.DetailEventScreen
import com.example.eventyukapp.ui.theme.EventYukAppTheme


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventYukApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute == Screen.Beranda.route) {
                // Add top bar content here if needed
            }
        },
        bottomBar = {
            if (currentRoute == Screen.Beranda.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier.fillMaxWidth()
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(Screen.OnBoarding.route) {
                OnBoardingScreen(navController = navController)
            }
            composable(Screen.Login.route) {
                LoginScreen(navController = navController)
            }
            composable(Screen.Beranda.route) {
                BerandaScreen(navController = navController)
            }
            composable("detail/{eventId}") { backStackEntry ->
                val eventId = backStackEntry.arguments?.getString("eventId")?.toInt()
                eventId?.let {
                    DetailEventScreen(eventId = it, onBackPressed = { navController.popBackStack() }, navController = navController)
                }
            }
            composable("reminder") {
                ReminderScreen(
                    onReminderSet = { eventName, eventMillis ->
                        // Handle reminder set logic here
                    },
                    navController = navController
                )
            }

        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_beranda),
                icon = painterResource(id = R.drawable.icon_home),
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_acara),
                icon = painterResource(id = R.drawable.icon_acara),
                screen = Screen.Acara
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_notifikasi),
                icon = painterResource(id = R.drawable.icon_notifikasi),
                screen = Screen.Notifikasi
            ),
        )

        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    val iconTint = if (currentRoute == item.screen.route) {
                        Color(0xFF2196F3) // Warna ikon saat dipilih
                    } else {
                        Color.DarkGray // Warna ikon saat tidak dipilih
                    }
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title,
                        tint = iconTint,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.title) }
            )
        }
    }
}

@Composable
private fun BackButton(navController: NavController, iconResId: Int, contentDescription: String) {
}