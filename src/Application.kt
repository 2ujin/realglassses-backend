package com.realglasses

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.realglasses.config.DatabaseConfig
import com.realglasses.router.question
import com.realglasses.router.relation
import com.realglasses.service.QuestionService
import com.realglasses.service.RelationService
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
const val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.main(testing: Boolean = false) {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
            registerModule(JavaTimeModule().apply {
                addSerializer(
                    LocalDateTimeSerializer(
                        DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
                    )
                )
                addDeserializer(
                    LocalDateTime::class.java,
                    LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
                )
            })
        }
    }
    install(Routing) {
        relation(RelationService())
        question(QuestionService())
        DatabaseConfig.init()
    }
}

