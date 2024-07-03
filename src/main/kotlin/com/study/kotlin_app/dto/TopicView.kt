package com.study.kotlin_app.dto

import com.study.kotlin_app.model.enums.StatusTopc
import java.time.LocalDateTime
import java.util.UUID

data class TopicView (
        val uuid: UUID,
        val title: String,
        val menssage: String,
        val status: StatusTopc,
        val dateCreate: LocalDateTime
)
