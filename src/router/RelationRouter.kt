package com.realglasses.router

import com.realglasses.service.RelationService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.relation() {

    route("relations") {
        get {
            call.respond("response to relation")
        }
    }
}