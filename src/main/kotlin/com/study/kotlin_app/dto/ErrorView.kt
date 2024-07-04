package com.study.kotlin_app.dto

import java.time.LocalDateTime

data class ErrorView<T>(
        val timestamp: LocalDateTime = LocalDateTime.now(),
        val status: Int,
        val codeError: Int,
        val error: String,
        val message: T?,
        val path: String
)
