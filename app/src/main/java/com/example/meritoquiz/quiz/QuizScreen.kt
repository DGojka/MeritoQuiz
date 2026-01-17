package com.example.meritoquiz.quiz

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.meritoquiz.quiz.model.Question

@Composable
fun QuizScreen(
    onFinish: () -> Unit = {},
    viewModel: QuizViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    QuizScreenContent(
        onFinish = onFinish,
        uiState = uiState,
        onNextQuestionClick = viewModel::loadNextQuestion
    )
}

@Composable
private fun QuizScreenContent(
    onFinish: () -> Unit,
    uiState: QuizUiState,
    onNextQuestionClick: () -> Unit
) {
    val question = uiState.question
    var selectedAnswer by remember(question) { mutableStateOf<String?>(null) }
    val isAnswerCorrect by remember(question, selectedAnswer) { 
        derivedStateOf { selectedAnswer != null && selectedAnswer == question?.correctAnswer }
    }
    
    val animatedProgress by animateFloatAsState(
        targetValue = uiState.progress,
        animationSpec = tween(durationMillis = 1000)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F4FA)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFF007AFF),
                            Color(0xFF0066FF)
                        )
                    ),
                    shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                if (uiState.totalQuestions > 0) {
                    Text(
                        text = "Question ${uiState.currentQuestionNumber}/${uiState.totalQuestions}",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = animatedProgress,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        color = Color.White,
                        backgroundColor = Color.White.copy(alpha = 0.3f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(150.dp),
                    shape = RoundedCornerShape(25.dp),
                    backgroundColor = Color.White
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = question?.questionText ?: "Loading question...",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .weight(1.5f) 
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            question?.answers?.forEach { answer ->
                AnswerButton(
                    text = answer,
                    onClick = { selectedAnswer = answer },
                    isSelected = selectedAnswer == answer,
                    isCorrect = if (selectedAnswer == answer) isAnswerCorrect else null
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (uiState.currentQuestionNumber == uiState.totalQuestions) {
                        onFinish()
                    } else {
                        onNextQuestionClick()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(55.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF007AFF)
                ),
                enabled = isAnswerCorrect
            ) {
                Text(
                    text = if (uiState.currentQuestionNumber == uiState.totalQuestions && isAnswerCorrect) "Finish" else "Next",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun AnswerButton(
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    isCorrect: Boolean?
) {
    val borderColor = when {
        isSelected && isCorrect == true -> Color(0xFF38A800) // Green
        isSelected && isCorrect == false -> Color(0xFFD32F2F) // Red
        else -> Color.LightGray.copy(alpha = 0.5f)
    }

    val backgroundColor = when {
        isSelected && isCorrect == true -> Color(0xFFE8F5E9)
        isSelected && isCorrect == false -> Color(0xFFFFEBEE)
        else -> Color.White
    }

    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .height(60.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = backgroundColor,
            contentColor = Color.DarkGray
        ),
        border = BorderStroke(2.dp, borderColor),
    ) {
        Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    val previewUiState = QuizUiState(
        question = Question(
            questionText = "What is the capital of Poland?",
            answers = listOf("Warsaw", "Berlin", "Prague", "Kyiv"),
            correctAnswer = "Warsaw"
        ),
        currentQuestionNumber = 1,
        totalQuestions = 3,
        progress = 1f / 3f
    )
    QuizScreenContent(onFinish = {}, uiState = previewUiState, onNextQuestionClick = {})
}
