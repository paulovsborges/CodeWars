package codewars.katas

class DuplicatedCount {

    operator fun invoke(text: String): Int{
        return text.lowercase().groupingBy { it }.eachCount().filter {
             it.value > 1
         }.size
    }
}