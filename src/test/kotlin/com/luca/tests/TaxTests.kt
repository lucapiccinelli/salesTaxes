package com.luca.tests

import com.luca.core.Money
import com.luca.core.Tax
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TaxTests {

    @ParameterizedTest
    @CsvSource(value = [
        "0.1,14.99,1.5",
        "0.1,14.50,1.45",
        "0.1,14.49,1.45",
        "0.1,14.39,1.45",
        "0.05,14.39,0.75",
    ])
    fun `GIVEN a tax value WHEN i apply it to some money THEN it is rounded up to the nearest 0_05`(taxAmount: Double, MoneyAmount: Double, expectedCharge: Double) {
        val tax = Tax(taxAmount)
        val money = Money(MoneyAmount)

        val chargedValue = money * tax
        chargedValue shouldBe Money(expectedCharge)
    }

}