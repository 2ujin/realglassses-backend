package com.realglasses.model

class Relation(id: EntityID<Int>) : IntEntity(id) { // 2
    companion object : IntEntityClass<Todo>(Todos)
    var id by Todos.content
    var name by Todos.done

}