package com.study.kotlin_app.model

import java.util.UUID

data class User (
        val uuid: UUID,
        val name: String,
        val email: String
        )