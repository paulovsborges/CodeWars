package codewars

import codewars.katas.IWordsSpinner
import codewars.katas.WordsSpinner
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpinWordsTest {

    private lateinit var spinner: IWordsSpinner

    @BeforeEach
    fun setup() {
        spinner = WordsSpinner()
    }

    @ParameterizedTest
    @MethodSource("provideParameterizedData")
    fun `reverse words`(
        data: ParameterizedData
    ) {
        val actualResult = spinner(data.input)

        assertEquals(data.expectedResult, actualResult)
    }

    private fun provideParameterizedData(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                ParameterizedData(
                    input = "Welcome",
                    expectedResult = "emocleW"
                )
            ),
            Arguments.of(
                ParameterizedData(
                    input = "Hey fellow warriors",
                    expectedResult = "Hey wollef sroirraw"
                )
            ),
            Arguments.of(
                ParameterizedData(
                    input = "This is a test",
                    expectedResult = "This is a test"
                )
            ),
            Arguments.of(
                ParameterizedData(
                    input = "This is another test",
                    expectedResult = "This is rehtona test"
                )
            ),
            Arguments.of(
                ParameterizedData(
                    input = "You are almost to the last test",
                    expectedResult = "You are tsomla to the last test"
                )
            ),
            Arguments.of(
                ParameterizedData(
                    input = "Just kidding there is still one more",
                    expectedResult = "Just gniddik ereht is llits one more"
                )
            ),
        )
    }

    data class ParameterizedData(
        val input: String,
        val expectedResult: String
    )
}