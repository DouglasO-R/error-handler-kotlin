package com.oliveira.errorHandler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ErrorHandlerApplication

fun main(args: Array<String>) {
	runApplication<ErrorHandlerApplication>(*args)
}
