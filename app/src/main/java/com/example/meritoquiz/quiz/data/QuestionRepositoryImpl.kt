package com.example.meritoquiz.quiz.data

import com.example.meritoquiz.quiz.domain.repository.QuestionRepository
import com.example.meritoquiz.quiz.model.Question
import kotlinx.coroutines.delay
import javax.inject.Singleton

@Singleton
class QuestionRepositoryImpl : QuestionRepository {

    private var cachedQuestions: List<Question> = emptyList()

    override suspend fun fetchAndCacheQuestions() {
        if (cachedQuestions.isEmpty()) {
            delay(2000)
            cachedQuestions = listOf(
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
        }
    }

    override fun getQuestion(id: Int): Question? {
        return cachedQuestions.getOrNull(id - 1)
    }

    override fun getQuestionsCount(): Int {
        return cachedQuestions.size
    }
}
