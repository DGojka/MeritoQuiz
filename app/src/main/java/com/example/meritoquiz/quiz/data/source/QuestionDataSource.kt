package com.example.meritoquiz.quiz.data.source

import com.example.meritoquiz.quiz.data.QuestionSet
import com.example.meritoquiz.quiz.model.Question

interface QuestionDataSource {
    fun getQuestions(questionSet: QuestionSet): List<Question>
}
