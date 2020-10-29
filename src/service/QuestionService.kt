package com.realglasses.service

import com.realglasses.config.DatabaseConfig
import com.realglasses.model.QuestionByRelation
import com.realglasses.model.QuestionEntity
import com.realglasses.model.QuestionResponse
import org.jetbrains.exposed.sql.select

class QuestionService {
    suspend fun getAll() = DatabaseConfig.query {
        QuestionEntity.all()
            .map(QuestionResponse.Companion::of)
            .toList()
    }

    suspend fun getAllByRelationId(id: Int) = DatabaseConfig.query {
        QuestionByRelation.select { QuestionByRelation.relationId eq id }
            .mapNotNull { qbr -> QuestionEntity.findById(qbr[QuestionByRelation.questionId]) }
            .map(QuestionResponse.Companion::of)
            .toList()
    }
}