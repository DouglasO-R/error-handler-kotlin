package com.oliveira.errorHandler.service

import com.oliveira.errorHandler.exception.ArticleNotFoundException
import com.oliveira.errorHandler.model.Article
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class ArticleService {
    lateinit var articles: List<Article>

    @PostConstruct
    fun buildArticles() {
        articles = listOf(
            Article("1", "Exception Handler in Kotlin"),
            Article("2", "Validation in Kotlin"),
            Article("3", "Spring in Kotlin"),
        )
    }

    fun createArticle(title: String): Article {
        val article = articles.find { article: Article -> article.title == title }

        if (article != null) {
            throw IllegalStateException("Article with the same title already exists")
        }
        val nextId = (articles.size + 1).toString()

        return Article(nextId, title)
    }

    fun getArticle(id: String): Article {
        return articles.find<Article> { article -> article.id == id }
            ?: throw ArticleNotFoundException("Article not found")
    }

    fun updateArticle(id: String, title: String): Article {
        val article = articles.find<Article> { article -> article.id == id }
            ?: throw ArticleNotFoundException("Article not found")

        if (title.length > 50) {
            throw IllegalArgumentException("Article title too long")
        }

        article.title = title
        return article
    }
}

