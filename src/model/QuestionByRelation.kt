package com.realglasses.model

import org.jetbrains.exposed.sql.Table


object QuestionByRelation : Table("question_by_relation") {
    val questionId = integer("question_id")
    val relationId = integer("relation_id")

    override val primaryKey = PrimaryKey(questionId, relationId, name = "CustomPKConstraintName")
}
