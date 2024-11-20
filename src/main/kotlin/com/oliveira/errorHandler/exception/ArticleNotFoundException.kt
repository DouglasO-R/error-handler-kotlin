package com.oliveira.errorHandler.exception

data class ArticleNotFoundException(override val message:String):RuntimeException(message)
