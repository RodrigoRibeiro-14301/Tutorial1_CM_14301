package org.example
import java.util.*

fun main() {
    val bounces = generateSequence(100.0) { lastHeight ->
        lastHeight * 0.60
    }

    val qualifyingBounces = bounces
        .takeWhile { it >= 0.0 }
        .take(15)
        .toList()

    println("Bounce Heights:")
    qualifyingBounces.forEach { height ->
        val rounded = String.format("%.2f", height)
        println("$rounded meters")
    }
}