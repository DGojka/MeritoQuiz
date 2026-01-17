package com.example.meritoquiz.quiz.domain

import com.example.meritoquiz.quiz.domain.repository.QuestionRepository
import javax.inject.Inject

class GetQuestionsCountUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    fun invoke(): Int {
        return repository.getQuestionsCount()
    }
}
