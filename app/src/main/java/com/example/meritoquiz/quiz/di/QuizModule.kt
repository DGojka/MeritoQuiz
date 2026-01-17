package com.example.meritoquiz.quiz.di

import com.example.meritoquiz.quiz.data.QuestionRepositoryImpl
import com.example.meritoquiz.quiz.domain.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuizModule {

    @Provides
    @Singleton
    fun provideQuestionRepository(): QuestionRepository {
        return QuestionRepositoryImpl()
    }
}
