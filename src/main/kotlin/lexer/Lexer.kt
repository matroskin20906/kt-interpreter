package org.example.lexer

import org.example.token.Token
import org.example.token.TokenType

class Lexer(private val input: String) {
    init {
        readChar()
    }

    private var position = 0
    private var readPosition = 0
    private var char = '\u0000'

    fun readChar() {
        char = if (readPosition >= input.length) {
            '\u0000'
        } else {
            input[readPosition]
        }
        position = readPosition
        readPosition++
    }

    fun peekChar() = if (readPosition >= input.length) {
        '\u0000'
    } else {
        input[readPosition]
    }

    fun nextToken(): Token {
        skipWhitespace()

        val token = when (char) {
            '!' -> when (peekChar()) {
                '=' -> {
                    val prevChar = char
                    readChar()
                    Token(TokenType.NOT_EQUALS, prevChar.toString() + char)
                }
                else -> Token(TokenType.BANG, char.toString())
            }
            '=' -> when (peekChar()) {
                '=' -> {
                    val prevChar = char
                    readChar()
                    Token(TokenType.EQUALS, prevChar.toString() + char)
                }
                else -> Token(TokenType.ASSIGN, char.toString())
            }
            '+' -> Token(TokenType.PLUS, char.toString())
            '-' -> Token(TokenType.MINUS, char.toString())
            '/' -> Token(TokenType.SLASH, char.toString())
            '*' -> Token(TokenType.ASTERISK, char.toString())
            '<' -> Token(TokenType.LT, char.toString())
            '>' -> Token(TokenType.GT, char.toString())
            ';' -> Token(TokenType.SEMICOLON, char.toString())
            '(' -> Token(TokenType.LPAREN, char.toString())
            ')' -> Token(TokenType.RPAREN, char.toString())
            '{' -> Token(TokenType.LBRACE, char.toString())
            '}' -> Token(TokenType.RBRACE, char.toString())
            ',' -> Token(TokenType.COMMA, char.toString())
            '\u0000' -> Token(TokenType.EOF, "")
            else -> {
                if (char.isLetter()) {
                    return readIdent().let { Token(it.tokenType, it) }
                } else if (char.isDigit()) {
                    return Token(TokenType.INT, readDigit())
                } else {
                    Token(TokenType.ILLEGAL, char.toString())
                }
            }
        }

        readChar()
        return token
    }

    fun skipWhitespace() {
        while (char.isWhitespace()) {
            readChar()
        }
    }

    fun readIdent(): String {
        val startPos = position
        while (char.isLetter()) {
            readChar()
        }

        return input.substring(startPos, position)
    }

    fun readDigit(): String {
        val startPos = position
        while (char.isDigit()) {
            readChar()
        }

        return input.substring(startPos, position)
    }

    private val String.tokenType get() = Token.keywords[this] ?: TokenType.IDENT
}