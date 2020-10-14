package com.luca.tests

import com.luca.core.*
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory


class PrintReceiptTests {

    private val sale1 = Sale.from(
        SaleLine(1, Book("Harry Potter", Money(12.49))),
        SaleLine(1, MusicCd("Metallica", Money(16.49))),
        SaleLine(1, Food("Chocolate bar", Money(0.85))),
    ) to  """
       1 book: 12.49
       1 music CD: 16.49
       1 chocolate bar: 0.85
       Sales Taxes: 1.50
       Total: 29.83
    """.trimIndent()

    @TestFactory
    internal fun `GIVEN a sale WHEN i request for a receipt THEN it strings as expected`() = listOf(
        sale1
    ).map{ (sale, expectedReceipt) ->
        DynamicTest.dynamicTest("receipt of $sale should be $expectedReceipt"){

            val receipt = sale.receipt()

            receipt.toString() shouldBe expectedReceipt
        }
    }
}

