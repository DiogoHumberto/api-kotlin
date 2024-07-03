package com.study.kotlin_app.model

import com.study.kotlin_app.model.enums.StatusTopc
import java.time.LocalDateTime
import java.util.UUID

data class Topic (
        var uuid: UUID = UUID.randomUUID(),
        val title: String,
        val menssage: String,
        val dateCreate: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val user: User,
        val satus: StatusTopc = StatusTopc.NOT_RESPONSE,
        val responses: List<Response> = ArrayList()
)