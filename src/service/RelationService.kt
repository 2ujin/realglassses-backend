package com.realglasses.service

import com.realglasses.config.DatabaseConfig
import com.realglasses.model.RelationEntity
import com.realglasses.model.RelationResponse

class RelationService {
    suspend fun getAll() = DatabaseConfig.query {
        RelationEntity.all()
            .map(RelationResponse.Companion::of)
            .toList()
    }
}