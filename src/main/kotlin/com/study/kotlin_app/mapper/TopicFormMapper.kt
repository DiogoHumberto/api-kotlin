package com.study.kotlin_app.mapper

import com.study.kotlin_app.dto.NewTopicForm
import com.study.kotlin_app.model.Topic
import com.study.kotlin_app.service.CourseService
import com.study.kotlin_app.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
        private val courseService: CourseService,
        private val userService: UserService
): Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
                title = t.title,
                menssage = t.menssage,
                course = courseService.findByUuid(t.uuidCourse),
                user = userService.findByUuid(t.uuidUser)
        )
    }


}