package codewars

interface IWordsSpinner {
    operator fun invoke(input: String): String
}

class WordsSpinner : IWordsSpinner {

    override fun invoke(input: String): String {

        val result = input
            .split(" ")
            .joinToString(separator = " ") {
                if (it.length >= 5) {
                    it.reversed()
                } else {
                    it
                }
            }

        return result
    }
}