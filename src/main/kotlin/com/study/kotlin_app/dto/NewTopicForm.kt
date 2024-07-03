package com.study.kotlin_app.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.UUID

data class NewTopicForm(
        @field: NotBlank
        val title: String,
        @field: NotBlank
        val menssage: String,
        @field:NotNull 
        val uuidCourse: UUID,
        @field:NotNull
        val uuidUser: UUID
)
