package com.realglasses.service

class RelationService {
    suspend fun getAll() = query {
        Todo.all()
            .orderBy(Todos.id to SortOrder.DESC)
            .map(TodoResponse.Companion::of)
            .toList()
    }
}