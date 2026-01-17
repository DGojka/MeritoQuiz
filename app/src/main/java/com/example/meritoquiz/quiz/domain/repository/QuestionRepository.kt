package com.example.meritoquiz.quiz.domain.repository

import com.example.meritoquiz.quiz.data.QuestionSet
import com.example.meritoquiz.quiz.model.Question

interface QuestionRepository {
    suspend fun fetchAndCacheQuestions(questionSet: QuestionSet = QuestionSet.WSB_UNIVERSITY)
    fun getQuestion(id: Int): Question?
    fun getQuestionsCount(): Int
}
