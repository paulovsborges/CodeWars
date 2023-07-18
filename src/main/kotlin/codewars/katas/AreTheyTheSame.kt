package codewars.katas

interface IAreTheyTheSame {
    operator fun invoke(
        a: IntArray?,
        b: IntArray?
    ): Boolean
}

class AreTheyTheSame : IAreTheyTheSame {

    override fun invoke(
        a: IntArray?,
        b: IntArray?
    ): Boolean {
        if (a == null || b == null) return false

        val squaredList = a.map { it * it }.sorted()
        val sortedB = b.sorted()

        return squaredList == sortedB
    }
}