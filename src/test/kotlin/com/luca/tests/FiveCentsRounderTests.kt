package com.luca.tests

import com.luca.core.FiveCentsRounder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class FiveCentsRounderTests {

    @ParameterizedTest
    @CsvSource(value = [
        "1.43,1.45",
        "1.39,1.40",
        "1.01,1.05",
        "1.05,1.05",
        "1.07,1.10",
        "0.07,0.10",
        "0.02,0.05",
    ])
    internal fun `GIVEN a value below the next 0_05 WHEN rounded THEN it should give the next 0_05`(belowValue: Double, next0_05Value: Double) {
        val rounded = FiveCentsRounder.round(BigDecimal.valueOf(belowValue))
        val roundedDouble = rounded.toDouble()
        roundedDouble shouldBe next0_05Value
    }
}