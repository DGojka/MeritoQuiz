package com.example.meritoquiz.quiz.di

import com.example.meritoquiz.quiz.data.QuestionRepositoryImpl
import com.example.meritoquiz.quiz.data.source.LocalQuestionDataSource
import com.example.meritoquiz.quiz.data.source.QuestionDataSource
import com.example.meritoquiz.quiz.domain.repository.QuestionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class QuizModule {

    @Binds
    @Singleton
    abstract fun bindQuestionRepository(impl: QuestionRepositoryImpl): QuestionRepository

    @Binds
    @Singleton
    abstract fun bindQuestionDataSource(impl: LocalQuestionDataSource): QuestionDataSource
}
