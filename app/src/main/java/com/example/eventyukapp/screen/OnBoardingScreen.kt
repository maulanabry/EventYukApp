package com.example.eventyukapp.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.eventyukapp.data.OnBoardingData
import com.example.eventyukapp.model.OnBoardingItem
import kotlinx.coroutines.launch
import com.airbnb.lottie.compose.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.eventyukapp.navigation.Screen
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val onBoardings = OnBoardingData.onBoardingItems

    OnBoardingContent(
        onBoardings = onBoardings,
        moveToHomeLoginScreen = {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.OnBoarding.route) { inclusive = true }
            }
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingContent(
    onBoardings: List<OnBoardingItem>,
    moveToHomeLoginScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { onBoardings.size })
    val (selectedPage, setSelectedPage) = remember { mutableIntStateOf(0) }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            setSelectedPage(page)
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = modifier.padding(it)) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(0.6f)
            ) { page ->
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(
                        onBoardings[page].resId
                    )
                )

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                ) {
                    Text(
                        text = onBoardings[page].title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0xFF2196F3)
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = onBoardings[page].description,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    LottieAnimation(
                        composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .width(400.dp)
                            .height(400.dp)
                    )
                }
            }

            // Indicator dots for pages
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                for (i in onBoardings.indices) {
                    Box(
                        modifier = Modifier
                            .padding(end = if (i == onBoardings.size - 1) 0.dp else 5.dp)
                            .width(if (i == selectedPage) 20.dp else 10.dp)
                            .height(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                ButtonDefaults.buttonColors(
                                    containerColor = if (i == selectedPage) Color(0xFF2196F3) else MaterialTheme.colorScheme.background
                                ).containerColor
                            )
                    )
                }
            }

            // "Skip" and "Next" buttons
            if (selectedPage != onBoardings.size - 1) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TextButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(onBoardings.size - 1)
                            }
                        },
                        modifier = Modifier.height(48.dp)
                    ) {
                        Text(
                            text = "Skip",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFF2196F3)
                        )
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                val nextPage = selectedPage + 1
                                pagerState.animateScrollToPage(nextPage)
                            }
                        },
                        modifier = Modifier.height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        )
                    ) {
                        Text(
                            text = "Next",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

            // "Mulai" button
            if (selectedPage == onBoardings.size - 1) {
                Button(
                    onClick = {
                        moveToHomeLoginScreen()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(MaterialTheme.shapes.extraLarge),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    )
                ) {
                    Text(
                        text = "Mulai",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(navController = rememberNavController())
}