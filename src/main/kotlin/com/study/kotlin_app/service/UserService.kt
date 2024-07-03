package com.study.kotlin_app.service
import com.study.kotlin_app.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var users: List<User>) {

    init {
        users = Arrays.asList(User(
                uuid = UUID.fromString("505aad6a-b1a4-4677-942b-22096bc7e352"),
                name = "jose Silva",
                email = "jose@email.com.br"
        ))
    }

    fun findByUuid(uuid: UUID): User {
        return users.stream().filter({
            u -> u.uuid == uuid
        }).findFirst().get()
    }
}