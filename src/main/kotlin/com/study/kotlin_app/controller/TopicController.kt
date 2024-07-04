package com.study.kotlin_app.controller

import com.study.kotlin_app.dto.NewTopicForm
import com.study.kotlin_app.dto.TopicView
import com.study.kotlin_app.dto.UpdateTopicForm
import com.study.kotlin_app.model.Topic
import com.study.kotlin_app.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.UUID

@RestController
@RequestMapping("/topic")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): ResponseEntity<List<TopicView>> {

        return ResponseEntity.ok().body(topicService.list());

    }

    @GetMapping("/{uuid}")
    fun findByUuid(@PathVariable uuid: UUID): ResponseEntity<TopicView> {
        return ResponseEntity.ok().body(topicService.findByUuid(uuid))
    }

    @PostMapping
    fun create(@RequestBody @Valid form: NewTopicForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView> {

        val topicView = topicService.create(form)

        return ResponseEntity.created(uriBuilder.path("/topic/{uuid}").buildAndExpand(topicView.uuid).toUri()).body(topicView);

    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm, uriBuilder: UriComponentsBuilder) : ResponseEntity<TopicView> {

        return ResponseEntity.ok().body(topicService.updtate(form))

    }

    @DeleteMapping("/{uuid}")
    fun delete(@PathVariable uuid: UUID) : ResponseEntity<TopicView>{

        topicService.delete(uuid)
        return ResponseEntity.noContent().build()
    }


}