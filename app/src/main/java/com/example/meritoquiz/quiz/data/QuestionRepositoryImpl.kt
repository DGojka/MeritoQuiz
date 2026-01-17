package com.example.meritoquiz.quiz.data

import com.example.meritoquiz.quiz.data.source.QuestionDataSource
import com.example.meritoquiz.quiz.domain.repository.QuestionRepository
import com.example.meritoquiz.quiz.model.Question
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionRepositoryImpl @Inject constructor(
    private val questionDataSource: QuestionDataSource
) : QuestionRepository {

    private var cachedQuestions: List<Question> = emptyList()

    override suspend fun fetchAndCacheQuestions(questionSet: QuestionSet) {
        if (cachedQuestions.isEmpty()) {
            cachedQuestions = questionDataSource.getQuestions(questionSet)
        }
    }

    override fun getQuestion(id: Int): Question? {
        return cachedQuestions.getOrNull(id - 1)
    }

    override fun getQuestionsCount(): Int {
        return cachedQuestions.size
    }
}
