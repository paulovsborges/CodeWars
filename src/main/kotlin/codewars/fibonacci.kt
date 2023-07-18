package codewars

fun fibonacci(first: Int, second: Int) {
    val result = first + second
    println("$first + $second = $result")
    if (result < 100) {
        fibonacci(second, result)
    }
}