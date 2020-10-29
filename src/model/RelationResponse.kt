package com.realglasses.model

data class RelationResponse(
    val id: Int,
    val name: String
) {
    companion object {
        fun of(relation: RelationEntity) =
            RelationResponse(
                id = relation.id.value,
                name = relation.name
            )
    }
}