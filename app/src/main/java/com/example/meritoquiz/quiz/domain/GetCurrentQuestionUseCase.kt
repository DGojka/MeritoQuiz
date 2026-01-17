package com.example.meritoquiz.quiz.domain

import com.example.meritoquiz.quiz.domain.repository.QuestionRepository
import com.example.meritoquiz.quiz.model.Question
import javax.inject.Inject

class GetCurrentQuestionUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    operator fun invoke(questionId: Int): Question? {
        return repository.getQuestion(questionId)
    }
}
