package org.example.token

data class Token(val type: TokenType, val literal: String) {
    companion object {
        val keywords = mapOf(
            "fn" to TokenType.FUNCTION,
            "let" to TokenType.LET,
            "return" to TokenType.RETURN,

            "if" to TokenType.IF,
            "else" to TokenType.ELSE,

            "true" to TokenType.TRUE,
            "false" to TokenType.FALSE,
        )
    }
}