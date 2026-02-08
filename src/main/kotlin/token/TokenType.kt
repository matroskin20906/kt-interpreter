package org.example.token

enum class TokenType(val type: String) {
    ILLEGAL("ILLEGAL"),
    EOF("EOF"),

    IDENT("IDENT"),
    INT("INTEGER"),

    ASSIGN("="),
    PLUS("+"),

    COMMA(","),
    SEMICOLON(";"),

    LPAREN("("),
    RPAREN(")"),
    LBRACE("{"),
    RBRACE("}"),

    FUNCTION("FUNCTION"),
    LET("LET")
}