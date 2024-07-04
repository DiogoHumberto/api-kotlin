package com.study.kotlin_app.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.UUID

data class UpdateTopicForm(
        @field: NotNull
        val uuid: UUID,
        @field: NotBlank
        val title: String,
        @field: NotBlank
        val menssage: String
)
