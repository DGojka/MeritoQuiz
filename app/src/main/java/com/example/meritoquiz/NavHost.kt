package com.example.meritoquiz

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meritoquiz.home.HomeScreen
import com.example.meritoquiz.loading.LoadingScreen
import com.example.meritoquiz.quiz.CongratulationsScreen
import com.example.meritoquiz.quiz.QuizScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.LoadingScreen) {
        composable<AppScreen.LoadingScreen> {
            LoadingScreen(
                onLoadingFinished = {
                    navController.navigate(AppScreen.HomeScreen) {
                        popUpTo<AppScreen.LoadingScreen> { inclusive = true }
                    }
                }
            )
        }
        composable<AppScreen.HomeScreen> { 
            HomeScreen(
                onStartQuizClick = {
                    navController.navigate(AppScreen.QuizScreen)
                }
            )
        }
        composable<AppScreen.QuizScreen> { 
            QuizScreen(
                onFinish = {
                    navController.navigate(AppScreen.CongratulationsScreen) {
                        popUpTo<AppScreen.HomeScreen>()
                    }
                }
            )
        }
        composable<AppScreen.CongratulationsScreen> { 
            CongratulationsScreen(
                onBackToHomeClick = {
                    navController.navigate(AppScreen.HomeScreen) {
                        popUpTo<AppScreen.HomeScreen>() {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}