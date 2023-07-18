package codewars.katas

interface IConvertHexToRgb {
    operator fun invoke(hexString: String): RGB
}

class ConvertHexToRgb : IConvertHexToRgb {

    override fun invoke(hexString: String): RGB {
        val values = hexString.lowercase().removeRange(
            0..0
        ).chunked(2)

        val letters = mapOf(
            "a" to 10,
            "b" to 11,
            "c" to 12,
            "d" to 13,
            "e" to 14,
            "f" to 15,
        )

        val rgbValues = mutableListOf<Int>()

        values.forEach {

            val firstLetter = if (it.first().isDigit()) {
                it.first().digitToInt() * 16
            } else {
                val decimalValue = letters[it.first().toString()] ?: throw NullPointerException()

                decimalValue * 16
            }

            val secondLetter = if (it[1].isDigit()) {
                it[1].digitToInt()
            } else {
                val decimalValue = letters[it[1].toString()] ?: throw NullPointerException()

                decimalValue
            }

            val result = firstLetter + secondLetter

            val product = if (result <= 255) {
                result
            } else {
                255
            }

            rgbValues.add(product)
        }

        return RGB(rgbValues[0], rgbValues[1], rgbValues[2])
    }
}

data class RGB(
    val r: Int,
    val g: Int,
    val b: Int
)