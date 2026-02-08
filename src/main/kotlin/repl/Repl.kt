package org.example.repl

import org.example.lexer.Lexer
import org.example.token.TokenType
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter

const val PROMPT = ">>> "

class Repl(input: InputStream, output: OutputStream) {
    private val br = BufferedReader(InputStreamReader(input))
    private val bw = BufferedWriter(OutputStreamWriter(output))

    fun start() {
        while (true) {
            bw.write(PROMPT)
            bw.flush()

            val line = br.readLine()

            val lexer = Lexer(line)
            var token = lexer.nextToken()

            while (token.type != TokenType.EOF) {
                bw.write(token.toString() + "\n")
                token = lexer.nextToken()
            }
            bw.flush()
        }
    }
}