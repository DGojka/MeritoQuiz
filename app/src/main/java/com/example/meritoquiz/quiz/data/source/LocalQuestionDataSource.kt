package com.example.meritoquiz.quiz.data.source

import com.example.meritoquiz.quiz.data.QuestionSet
import com.example.meritoquiz.quiz.model.Question
import javax.inject.Inject

class LocalQuestionDataSource @Inject constructor() : QuestionDataSource {

    private val generalKnowledgeQuestions = listOf(
        Question(
            questionText = "Jaka jest stolica Polski?",
            answers = listOf("Warszawa", "Berlin", "Praga", "Kijów"),
            correctAnswer = "Warszawa"
        ),
        Question(
            questionText = "Jaki jest najmniejszy kontynent na świecie?",
            answers = listOf("Azja", "Australia", "Europa", "Antarktyda"),
            correctAnswer = "Australia"
        ),
        Question(
            questionText = "W którym roku odbyła się bitwa pod Grunwaldem?",
            answers = listOf("1410", "1000", "1999", "2024"),
            correctAnswer = "1410"
        ),
        Question(
            questionText = "Jaka jest stolica Polski?",
            answers = listOf("Warszawa", "Berlin", "Praga", "Kijów"),
            correctAnswer = "Warszawa"
        ),
        Question(
            questionText = "Jaki jest najmniejszy kontynent na świecie?",
            answers = listOf("Azja", "Australia", "Europa", "Antarktyda"),
            correctAnswer = "Australia"
        ),
    )

    private val wsbUniversityQuestions = listOf(
        Question(
            questionText = "Co historycznie oznacza skrót WSB?",
            answers = listOf("Wielka Szkoła Biznesu", "Wyższa Szkoła Bankowa", "Wspólna Szkoła Bankowości", "Wyższa Szkoła Budownictwa"),
            correctAnswer = "Wyższa Szkoła Bankowa"
        ),
        Question(
            questionText = "Jaką nową nazwę przyjęła większość Wyższych Szkół Bankowych w 2023 roku?",
            answers = listOf("Akademia Finansów i Biznesu", "Politechnika Bankowa", "Uniwersytet WSB Merito", "Szkoła Wyższa Meritum"),
            correctAnswer = "Uniwersytet WSB Merito"
        ),
        Question(
            questionText = "W którym roku powstała pierwsza Wyższa Szkoła Bankowa (w Poznaniu)?",
            answers = listOf("1998", "2000", "1994", "1990"),
            correctAnswer = "1994"
        ),
        Question(
            questionText = "Jaki status mają uczelnie z grupy WSB Merito?",
            answers = listOf("Uczelnie państwowe", "Uczelnie niepubliczne", "Szkoły policealne", "Instytucje charytatywne"),
            correctAnswer = "Uczelnie niepubliczne"
        ),
        Question(
            questionText = "W ilu miastach w Polsce funkcjonują uczelnie i wydziały WSB Merito?",
            answers = listOf("5", "20", "3", "11"),
            correctAnswer = "11"
        )
    )
    override fun getQuestions(questionSet: QuestionSet): List<Question> {
        return when (questionSet) {
            QuestionSet.GENERAL_KNOWLEDGE -> generalKnowledgeQuestions
            QuestionSet.WSB_UNIVERSITY -> wsbUniversityQuestions
        }
    }
}
