package com.example.news.data

import com.example.news.data.models.Article
import com.example.news.database.NewsDataBase
import com.example.newsapi.NewsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticlesRepository(
    private val database: NewsDataBase,
    private val api: NewsApi,
) {

    fun getAll(): RequestResult<Flow<List<Article>>> {
        return RequestResult.InProgress(database.articleDao.getAll()
            .map { articles -> articles.map { it.toArticle() } })
    }

    suspend fun search(query: String): Flow<Article> {
        TODO("not implemented")
    }
}

sealed class RequestResult<E>(protected val data: E?) {
    class InProgress<E>(data: E?) : RequestResult<E>(data)
    class Success<E>(data: E?) : RequestResult<E>(data)
    class Error<E>(data: E?) : RequestResult<E>(data)
}