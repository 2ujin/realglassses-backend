package com.realglasses

import com.realglasses.config.DatabaseConfig
import com.realglasses.router.relation
import com.realglasses.service.RelationService
import io.ktor.application.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.main(testing: Boolean = false) {
    install(Routing) {
        relation(RelationService())
        DatabaseConfig.init()
    }
}

