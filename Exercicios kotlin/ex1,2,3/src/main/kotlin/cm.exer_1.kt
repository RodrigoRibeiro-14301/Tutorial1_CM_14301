package org.example

fun main() {

    val squares = IntArray(50) { i ->
        val n = i + 1
        n * n
    }

    println(squares.joinToString())

    val squares2 = (1..50).map { n -> n * n }

        println(squares2.joinToString())

    val squares3 = Array(50) { i ->
        val n = i + 1
        n * n
    }

    println(squares3.joinToString())
}