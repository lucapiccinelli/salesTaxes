package com.luca.tests

import com.luca.core.*
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


class HelloTest {

    @Test
    internal fun `GIVEN a sale WHEN i request for a receipt THEN it strings as expected`() {
        val book = Book("Harry Potter", Money(12.49))
        val musicCd = MusicCd("Metallica", Money(14.99))
        val food = Food("Chocolate bar", Money(0.85))
        val sale = Sale(
            SaleLine(1, book),
            SaleLine(1, musicCd),
            SaleLine(1, food),
        )

        val receipt = sale.receipt()

        val expectedReceipt = """
           1 book : 12.49
           1 music CD: 16.49
           1 chocolate bar: 0.85
           Sales Taxes: 1.50
           Total: 29.83 
        """.trimIndent()

        receipt.toString() shouldBe expectedReceipt
    }
}

