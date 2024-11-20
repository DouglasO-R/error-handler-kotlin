package com.oliveira.errorHandler.controller

import com.oliveira.errorHandler.model.Article
import com.oliveira.errorHandler.service.ArticleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/articles")
class ArticleController(val articleService: ArticleService) {

    @PostMapping
    fun createArticle(@RequestBody title: String): Article {
        return articleService.createArticle(title)
    }

    @GetMapping
    fun getArticle(@RequestParam id: String): Article {
        return articleService.getArticle(id)
    }

    @PutMapping
    fun updateArticle(@RequestParam id: String, @RequestParam title: String): Article {
        return articleService.updateArticle(id, title)
    }
}


