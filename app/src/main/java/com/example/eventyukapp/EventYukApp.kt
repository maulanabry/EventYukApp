package com.example.eventyukapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.navigation.NavigationItem
import com.example.eventyukapp.navigation.Screen
import com.example.eventyukapp.screen.OnBoardingScreen
import com.example.eventyukapp.screen.SplashScreen

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
            // tambahin navigasi screen lainnya
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
                icon = { Icon(painter = item.icon, contentDescription = item.title, modifier = Modifier.size(24.dp)) },
                label = { Text(text = item.title) }
            )
        }
    }
}

@Composable
private fun BackButton(navController: NavController, iconResId: Int, contentDescription: String) {
    val painter: Painter = painterResource(id = iconResId)
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier
            .clickable {
                navController.popBackStack()
            }
            .padding(16.dp)
            .size(24.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun EventYukAppPrev() {
    EventYukApp()
}