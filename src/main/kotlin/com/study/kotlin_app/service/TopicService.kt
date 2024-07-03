package com.study.kotlin_app.service

import com.study.kotlin_app.dto.NewTopicForm
import com.study.kotlin_app.dto.TopicView
import com.study.kotlin_app.mapper.TopicFormMapper
import com.study.kotlin_app.mapper.TopicViewMapper
import com.study.kotlin_app.model.Topic
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.stream.Collectors

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper
        ) {

    fun list(): List<TopicView> {
        return topics.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findByUuid(uuid: UUID): TopicView {
        val topic = topics.stream().filter { t ->
            t.uuid == uuid
        }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun create(form: NewTopicForm) : TopicView {

        val topic = topicFormMapper.map(form)
        topics = topics.plus(topic)

        return topicViewMapper.map(topic)
    }
}