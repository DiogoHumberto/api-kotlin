package com.study.kotlin_app.service

import com.study.kotlin_app.exception.TopicNotFoundException
import com.study.kotlin_app.dto.NewTopicForm
import com.study.kotlin_app.dto.TopicView
import com.study.kotlin_app.dto.UpdateTopicForm
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

        return topicViewMapper.map(findInListByUuid(uuid))
    }

    fun create(form: NewTopicForm) : TopicView {

        val topic = topicFormMapper.map(form)
        topics = topics.plus(topic)

        return topicViewMapper.map(topic)
    }

    fun updtate(form: UpdateTopicForm) : TopicView {

        var old = findInListByUuid(form.uuid)

        val new = old.copy(title = form.title, menssage = form.menssage)

        saveUpdateTopic(new)

        return topicViewMapper.map(new)
    }

    fun delete(uuid: UUID): TopicView{

        val topic = findInListByUuid(uuid)

        topics = topics.filter { it.uuid != uuid }

        return topicViewMapper.map(topic)
    }



    private fun saveUpdateTopic(updatedTopic: Topic) {

        topics = topics.map { if (it.uuid == updatedTopic.uuid) updatedTopic else it }

    }

    private fun findInListByUuid(uuid: UUID) : Topic {
       return topics.stream().filter { t -> t.uuid == uuid}
               .findFirst() .orElseThrow { TopicNotFoundException("Topic with UUID $uuid not found") }

    }
}