package com.study.kotlin_app.service

import com.study.kotlin_app.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course>) {

    //mock use without database
    init {
        courses = Arrays.asList(
                Course(uuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
                name = "teste", category = "teste"))
    }

    fun findByUuid(uuid: UUID) : Course {
        return courses.stream().filter({s -> s.uuid == uuid}).findFirst().get()
    }

}