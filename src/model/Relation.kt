package com.realglasses.model

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Relation : IntIdTable() {
    val name = text("name").default("")
}

class RelationEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RelationEntity>(Relation)

    var name by Relation.name
}