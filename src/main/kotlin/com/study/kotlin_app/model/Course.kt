package com.study.kotlin_app.model

import java.util.UUID

data class Course (
        val uuid: UUID,
        val name: String,
        val category: String
)