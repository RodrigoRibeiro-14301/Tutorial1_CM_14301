package org.example

fun main() {
    println("Simple Calculator in Kotlin")

    print("Enter operator (+, -, *, /, &&, ||, !): ")
    val operator = readLine()

    when (operator) {

        "+", "-", "*", "/" -> {
            print("Enter first number: ")
            val num1 = readLine()!!.toDouble()

            print("Enter second number: ")
            val num2 = readLine()!!.toDouble()

            val result = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> 0.0
            }

            val intResult = result.toInt()

            println("Decimal: $result")
            println("Hexadecimal: 0x${intResult.toString(16).uppercase()}")
            println("Boolean: ${result != 0.0}")
        }

        "&&", "||" -> {
            print("Enter first boolean (true/false): ")
            val b1 = readLine()!!.toBoolean()

            print("Enter second boolean (true/false): ")
            val b2 = readLine()!!.toBoolean()

            val result = when (operator) {
                "&&" -> b1 && b2
                "||" -> b1 || b2
                else -> false
            }

            val intResult = if (result) 1 else 0

            println("Decimal: $intResult")
            println("Hexadecimal: 0x${intResult.toString(16).uppercase()}")
            println("Boolean: $result")
        }

        "!" -> {
            print("Enter a boolean (true/false): ")
            val b = readLine()!!.toBoolean()

            val result = !b
            val intResult = if (result) 1 else 0

            println("Decimal: $intResult")
            println("Hexadecimal: 0x${intResult.toString(16).uppercase()}")
            println("Boolean: $result")
        }

        "shl", "shr" ->{
            print("Digite um numero para bitwise shift operation:")
            val num1 = readLine()!!.toInt()
            print("Digite outro numero para bitwise shift operation:")
            val num2 = readLine()!!.toInt()

            val result = when (operator){
                "shl" -> num1 shl num2
                "shr" -> num1 shr num2
                else -> 0
            }

            println("Decimal: $result")
            println("Hexadecimal: 0x${result.toString(16).uppercase()}")
            println("Boolean: ${result.toDouble() != 0.0}")
        }

        else -> {
            println("Invalid operator")
        }
    }
}