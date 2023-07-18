package codewars.katas

interface ILexicographicalOrder {
    operator fun invoke(a1: List<String>, a2: List<String>): List<String>
}

class LexicographicalOrder : ILexicographicalOrder {

    override fun invoke(a1: List<String>, a2: List<String>): List<String> {
        return a1.filter { first ->
            a2.find { second ->
                first in second
            }?.let {
                true
            } ?: false
        }.distinct().sorted()
    }
}