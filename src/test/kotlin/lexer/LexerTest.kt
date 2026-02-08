package lexer

import org.example.lexer.Lexer
import org.example.token.Token
import org.example.token.TokenType
import kotlin.test.Test
import kotlin.test.assertEquals

class LexerTest {
    fun testExpectedTokens(input: String, expectedTokens: List<Token>) {
        val lexer = Lexer(input)

        expectedTokens.forEach {
            val token = lexer.nextToken()
            println(token)
            assertEquals(it, token)
        }
    }

    @Test
    fun `test lexer next token with small input`() {
        val input = "=+(){},;"

        val expectedTokens = listOf(
            Token(TokenType.ASSIGN, "="),
            Token(TokenType.PLUS, "+"),
            Token(TokenType.LPAREN, "("),
            Token(TokenType.RPAREN, ")"),
            Token(TokenType.LBRACE, "{"),
            Token(TokenType.RBRACE, "}"),
            Token(TokenType.COMMA, ","),
            Token(TokenType.SEMICOLON, ";"),
        )

        testExpectedTokens(input, expectedTokens)
    }

    @Test
    fun `test lexer next token with real program`() {
        val input = """
            let five = 5;
            let ten = 10;
            
            let add = fn(x, y) {
                x + y;
            };
            
            let result = add(five, ten);
        """.trimIndent()

        val expectedTokens = listOf(
            Token(TokenType.LET, "let"),
            Token(TokenType.IDENT, "five"),
            Token(TokenType.ASSIGN, "="),
            Token(TokenType.INT, "5"),
            Token(TokenType.SEMICOLON, ";"),

            Token(TokenType.LET, "let"),
            Token(TokenType.IDENT, "ten"),
            Token(TokenType.ASSIGN, "="),
            Token(TokenType.INT, "10"),
            Token(TokenType.SEMICOLON, ";"),

            Token(TokenType.LET, "let"),
            Token(TokenType.IDENT, "add"),
            Token(TokenType.ASSIGN, "="),
            Token(TokenType.FUNCTION, "fn"),
            Token(TokenType.LPAREN, "("),
            Token(TokenType.IDENT, "x"),
            Token(TokenType.COMMA, ","),
            Token(TokenType.IDENT, "y"),
            Token(TokenType.RPAREN, ")"),
            Token(TokenType.LBRACE, "{"),

            Token(TokenType.IDENT, "x"),
            Token(TokenType.PLUS, "+"),
            Token(TokenType.IDENT, "y"),
            Token(TokenType.SEMICOLON, ";"),

            Token(TokenType.RBRACE, "}"),
            Token(TokenType.SEMICOLON, ";"),

            Token(TokenType.LET, "let"),
            Token(TokenType.IDENT, "result"),
            Token(TokenType.ASSIGN, "="),
            Token(TokenType.IDENT, "add"),
            Token(TokenType.LPAREN, "("),
            Token(TokenType.IDENT, "five"),
            Token(TokenType.COMMA, ","),
            Token(TokenType.IDENT, "ten"),
            Token(TokenType.RPAREN, ")"),
            Token(TokenType.SEMICOLON, ";"),
            Token(TokenType.EOF, "")
        )

        testExpectedTokens(input, expectedTokens)
    }
}