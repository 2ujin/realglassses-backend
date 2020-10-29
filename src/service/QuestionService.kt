package com.realglasses.service

import com.realglasses.config.DatabaseConfig
import com.realglasses.model.QuestionEntity
import com.realglasses.model.QuestionResponse

class QuestionService {
    suspend fun getAll() = DatabaseConfig.query {
        QuestionEntity.all()
            .map(QuestionResponse.Companion::of)
            .toList()
    }
}