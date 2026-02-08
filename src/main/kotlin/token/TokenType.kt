package org.example.token

enum class TokenType(val type: String) {
    ILLEGAL("ILLEGAL"),
    EOF("EOF"),

    IDENT("IDENT"),
    INT("INTEGER"),

    ASSIGN("="),
    PLUS("+"),
    MINUS("-"),
    ASTERISK("*"),
    SLASH("/"),

    BANG("!"),

    LT("<"),
    GT(">"),
    EQUALS("=="),
    NOT_EQUALS("!="),

    COMMA(","),
    SEMICOLON(";"),

    LPAREN("("),
    RPAREN(")"),
    LBRACE("{"),
    RBRACE("}"),

    FUNCTION("FUNCTION"),
    LET("LET"),
    TRUE("TRUE"),
    FALSE("FALSE"),
    IF("IF"),
    ELSE("ELSE"),
    RETURN("RETURN"),
}