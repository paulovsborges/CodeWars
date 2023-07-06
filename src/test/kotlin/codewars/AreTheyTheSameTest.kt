package codewars

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AreTheyTheSameTest {

    private lateinit var subject: IAreTheyTheSame

    @BeforeEach
    fun setup() {
        subject = AreTheyTheSame()
    }

    @ParameterizedTest
    @MethodSource("provideParameterizedData")
    fun `should return that elements in a B array is equals to elements on array A squared`(
        data: ParameterizedData
    ) {

        val actualResult = subject(
            data.a?.toIntArray(),
            data.b?.toIntArray()
        )

        assertEquals(data.expectedResult, actualResult)
    }

    private fun provideParameterizedData(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                ParameterizedData(
                    listOf(121, 144, 19, 161, 19, 144, 19, 11),
                    listOf(121, 14641, 20736, 361, 25921, 361, 20736, 361),
                    true
                )
            ),
            Arguments.of(
                ParameterizedData(
                    listOf(121, 144, 19, 161, 19, 144, 19, 11),
                    listOf(132, 14641, 20736, 361, 25921, 361, 20736, 361),
                    false
                )
            ),
            Arguments.of(
                ParameterizedData(
                    listOf(121, 144, 19, 161, 19, 144, 19, 11),
                    listOf(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19),
                    true
                )
            ),
            Arguments.of(
                ParameterizedData(
                    listOf(121, 144, 19, 161, 19, 144, 19, 11),
                    listOf(121, 14641, 20736, 36100, 25921, 361, 20736, 361),
                    false
                )
            ),
            Arguments.of(
                ParameterizedData(
                    null,
                    listOf(121, 14641, 20736, 36100, 25921, 361, 20736, 361),
                    false
                )
            ),
            Arguments.of(
                ParameterizedData(
                    listOf(121, 144, 19, 161, 19, 144, 19, 11),
                    null,
                    false
                )
            ),
            Arguments.of(
                ParameterizedData(
                    null,
                    null,
                    false
                )
            ),
        )
    }

    data class ParameterizedData(
        val a: List<Int>?,
        val b: List<Int>?,
        val expectedResult: Boolean
    )
}