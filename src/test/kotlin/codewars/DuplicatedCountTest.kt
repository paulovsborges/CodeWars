package codewars

import com.sun.jdi.connect.Connector.Argument
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DuplicatedCountTest {

    @ParameterizedTest
    @MethodSource("provideParameterizedData")
    fun `should count repeated characters`(
        data: ParameterizedData
    ) {

        val input = data.text

        val actualResult = DuplicatedCount().invoke(input)

        assertEquals(data.expectedResult, actualResult)
    }

    private fun provideParameterizedData(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                ParameterizedData(
                    text = "aab",
                    expectedResult = 1
                )
            ),
            Arguments.of(
                ParameterizedData(
                    text = "aabb",
                    expectedResult = 2
                )
            ),
            Arguments.of(
                ParameterizedData(
                    text = "abc",
                    expectedResult = 0
                )
            ),
            Arguments.of(
                ParameterizedData(
                    text = "abcABC",
                    expectedResult = 3
                )
            ),
            Arguments.of(
                ParameterizedData(
                    text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000),
                    expectedResult = 3
                )
            ),
        )
    }

    data class ParameterizedData(
        val text: String,
        val expectedResult: Int
    )
}