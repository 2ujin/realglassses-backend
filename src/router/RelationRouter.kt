package com.realglasses.router

import com.realglasses.service.RelationService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.relation(service: RelationService) {

    route("relations") {
        get {
            call.respond(service.getAll())
        }
    }
}