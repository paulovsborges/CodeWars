package codewars

fun main() {
    fibonacci(0, 1)
}

private fun fibonacci(first: Int, second: Int) {
    val result = first + second
    println("$first + $second = $result")
    if (result < 100) {
        fibonacci(second, result)
    }
}