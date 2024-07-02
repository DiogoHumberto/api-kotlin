package com.study.kotlin_app.model

import java.util.UUID

data class Subject (
        val uuid: UUID,
        val name: String,
        val category: String
)