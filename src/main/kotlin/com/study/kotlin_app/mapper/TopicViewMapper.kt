package com.study.kotlin_app.mapper

import com.study.kotlin_app.dto.TopicView
import com.study.kotlin_app.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
                uuid = t.uuid,
                title = t.title,
                menssage = t.menssage,
                dateCreate = t.dateCreate,
                status = t.satus
        )
    }

}