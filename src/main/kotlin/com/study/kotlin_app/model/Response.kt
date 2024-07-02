package com.study.kotlin_app.model

import java.time.LocalDateTime
import java.util.UUID

data class Response(
        val uuid: UUID,
        val menssage: String,
        val dateCreate: LocalDateTime = LocalDateTime.now(),
        val user: User,
        val topic: Topic,
        val solution: Boolean

)
