package com.example.meritoquiz.quiz.domain.repository

import com.example.meritoquiz.quiz.model.Question

interface QuestionRepository {
    suspend fun fetchAndCacheQuestions()
    fun getQuestion(id: Int): Question?
    fun getQuestionsCount(): Int
}
