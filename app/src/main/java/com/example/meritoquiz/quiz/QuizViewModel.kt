package com.example.meritoquiz.quiz

import androidx.lifecycle.ViewModel
import com.example.meritoquiz.quiz.domain.GetCurrentQuestionUseCase
import com.example.meritoquiz.quiz.domain.GetQuestionsCountUseCase
import com.example.meritoquiz.quiz.model.Question
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class QuizUiState(
    val question: Question? = null,
    val currentQuestionNumber: Int = 0,
    val totalQuestions: Int = 0,
    val progress: Float = 0.0f
)

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getCurrentQuestionUseCase: GetCurrentQuestionUseCase,
    private val getQuestionsCountUseCase: GetQuestionsCountUseCase
) : ViewModel() {

    private var questionId = 1
    private val totalQuestions = getQuestionsCountUseCase.invoke()

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    init {
        loadQuestion()
    }

    fun loadNextQuestion() {
        if (questionId < totalQuestions) {
            questionId++
            loadQuestion()
        }
    }

    private fun loadQuestion() {
        val question = getCurrentQuestionUseCase(questionId)
        val progress = if (totalQuestions > 0) questionId.toFloat() / totalQuestions else 0.0f
        _uiState.value = QuizUiState(
            question = question,
            currentQuestionNumber = questionId,
            totalQuestions = totalQuestions,
            progress = progress
        )
    }
}
