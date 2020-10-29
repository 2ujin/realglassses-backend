package com.realglasses.router

import com.realglasses.service.QuestionService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.question(service: QuestionService) {

    route("questions") {
        get {
            call.respond(service.getAll())
        }
    }
}