package com.example.meritoquiz

import kotlinx.serialization.Serializable

@Serializable
sealed class AppScreen {
    @Serializable
    object LoadingScreen : AppScreen()

    @Serializable
    object HomeScreen : AppScreen()

    @Serializable
    object QuizScreen : AppScreen()

    @Serializable
    object CongratulationsScreen : AppScreen()
}