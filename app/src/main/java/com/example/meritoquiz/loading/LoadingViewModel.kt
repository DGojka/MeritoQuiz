package com.example.meritoquiz.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meritoquiz.quiz.domain.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            repository.fetchAndCacheQuestions()
            _isLoading.value = false
        }
    }
}
