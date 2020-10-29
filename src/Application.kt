package com.realglasses

import com.fasterxml.jackson.annotation.JsonInclude
import com.realglasses.config.DatabaseConfig
import com.realglasses.router.question
import com.realglasses.router.relation
import com.realglasses.service.QuestionService
import com.realglasses.service.RelationService
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.Routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.main(testing: Boolean = false) {
    install(ContentNegotiation) {
        jackson {
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }
    }
    install(Routing) {
        relation(RelationService())
        question(QuestionService())
        DatabaseConfig.init()
    }
}