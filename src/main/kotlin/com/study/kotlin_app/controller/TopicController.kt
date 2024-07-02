package com.study.kotlin_app.controller

import com.study.kotlin_app.model.Topic
import com.study.kotlin_app.service.TopicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): ResponseEntity<List<Topic>> {


        return ResponseEntity.ok().body(null);

    }
}