package com.realglasses.model

data class QuestionResponse(
    val id: Int,
    val content: String
) {
    companion object {
        fun of(question: QuestionEntity) =
            QuestionResponse(
                id = question.id.value,
                content = question.content
            )
    }
}
