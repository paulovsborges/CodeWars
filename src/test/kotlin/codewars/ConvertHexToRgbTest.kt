package codewars

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConvertHexToRgbTest {

    @ParameterizedTest
    @MethodSource("provideParameterizedData")
    fun `convert hex string to rgb`(
        data: ParameterizedData
    ) {

        val converter: IConvertHexToRgb = ConvertHexToRgb()
        val actualResult = converter(data.hexString)

        assertEquals(data.expectedResult, actualResult)
    }

    private fun provideParameterizedData(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                ParameterizedData(
                    hexString = "#FF9933",
                    expectedResult = RGB(
                        r = 255,
                        g = 153,
                        b = 51
                    )
                )
            ),
            Arguments.of(
                ParameterizedData(
                    hexString = "#beaded",
                    expectedResult = RGB(
                        r = 190,
                        g = 173,
                        b = 237
                    )
                )
            ),
            Arguments.of(
                ParameterizedData(
                    hexString = "#000000",
                    expectedResult = RGB(
                        r = 0,
                        g = 0,
                        b = 0
                    )
                )
            ),
            Arguments.of(
                ParameterizedData(
                    hexString = "#111111",
                    expectedResult = RGB(
                        r = 17,
                        g = 17,
                        b = 17
                    )
                )
            ),
            Arguments.of(
                ParameterizedData(
                    hexString = "#Fa3456",
                    expectedResult = RGB(
                        r = 250,
                        g = 52,
                        b = 86
                    )
                )
            ),
        )
    }

    data class ParameterizedData(
        val hexString: String,
        val expectedResult: RGB
    )
}