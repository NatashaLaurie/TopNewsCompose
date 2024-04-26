package com.example.news.main

import com.example.news.data.ArticlesRepository
import com.example.news.data.models.Article
import kotlinx.coroutines.flow.Flow

class GetAllArticlesUseCase(private val repository: ArticlesRepository) {
    suspend operator fun invoke(): Flow<Article> {
        return repository.getAll()
    }
}