package com.realglasses.service

import com.realglasses.config.DatabaseConfig.query
import com.realglasses.model.Relation
import com.realglasses.model.RelationEntity

class RelationService {
    suspend fun getAll() = query { RelationEntity.all() }
}