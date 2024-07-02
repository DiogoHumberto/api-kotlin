package com.study.kotlin_app.model

import com.study.kotlin_app.model.enums.StatusTopc
import java.time.LocalDateTime
import java.util.UUID

data class Topic (
        val uuid: UUID,
        val title: String,
        val menssage: String,
        val dateCreate: LocalDateTime = LocalDateTime.now(),
        val subject: Subject,
        val user: User,
        val satus: StatusTopc = StatusTopc.NOT_RESPONSE,
        val responses: List<Response> = ArrayList()
)