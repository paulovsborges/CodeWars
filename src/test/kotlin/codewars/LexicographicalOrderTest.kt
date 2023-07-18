package codewars

import codewars.katas.ILexicographicalOrder
import codewars.katas.LexicographicalOrder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LexicographicalOrderTest {

    private lateinit var subject: ILexicographicalOrder

    @BeforeEach
    fun setup() {
        subject = LexicographicalOrder()
    }

    @ParameterizedTest
    @MethodSource("provideParameterizedData")
    fun `retrieve lexicographical order`(
        data: ParameterizedData
    ) {

        val actualResult = subject(data.a1, data.a2)

        assertEquals(data.expectedResult, actualResult)
    }

    private fun provideParameterizedData(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                ParameterizedData(
                    a1 = listOf(
                        "xyz", "live", "live", "strong"
                    ),
                    expectedResult = listOf(
                        "live", "strong"
                    )
                )
            ),
            Arguments.of(
                ParameterizedData(
                    a1 = listOf("live", "strong", "arp"),
                    expectedResult = listOf("arp", "live", "strong")
                )
            ),
            Arguments.of(
                ParameterizedData(
                    a1 = listOf("tarp", "mice", "bull"),
                    expectedResult = listOf()
                )
            ),
        )
    }

    data class ParameterizedData(
        val a1: List<String>,
        val a2: List<String> = listOf(
            "lively", "alive", "harp", "sharp", "armstrong"
        ),
        val expectedResult: List<String>
    )
}