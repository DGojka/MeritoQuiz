package com.example.meritoquiz.quiz.model

data class Question(
    val questionText: String,
    val answers: List<String>,
    val correctAnswer: String
)
