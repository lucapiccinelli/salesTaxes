package com.luca.tests

import com.luca.core.*
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory


class PrintReceiptTests {

    private val sale1 = Sale.from(
        SaleLine(1, Book("Harry Potter", Money(12.49))),
        SaleLine(1, GenericItem("music CD", Money(14.99))),
        SaleLine(1, Food("Chocolate bar", Money(0.85))),
    ) to  """
       1 book: 12.49
       1 music CD: 16.49
       1 chocolate bar: 0.85
       Sales Taxes: 1.50
       Total: 29.83
    """.trimIndent()

    private val sale2 = Sale.from(
        SaleLine(2, Book("Harry Potter", Money(4))),
        SaleLine(2, GenericItem("fake banana", Money(1)))
    ) to  """
       2 book: 8.00
       2 fake banana: 2.20
       Sales Taxes: 0.20
       Total: 10.20
    """.trimIndent()

    private val sale3 = Sale.from(
        SaleLine(1, Imported(Food("box of chocolates", Money(10)))),
        SaleLine(1, Imported(GenericItem("bottle of perfume", Money(47.5))))
    ) to  """
       1 imported box of chocolates: 10.50
       1 imported bottle of perfume: 54.65
       Sales Taxes: 7.65
       Total: 65.15
    """.trimIndent()

    @TestFactory
    internal fun `GIVEN a sale WHEN i request for a receipt THEN it is printed as expected`() = listOf(
        sale1,
        sale2,
        sale3
    ).map{ (sale, expectedReceipt) ->
        DynamicTest.dynamicTest("receipt of $sale should be $expectedReceipt"){
            val receipt = sale.receipt()
            StringReceiptPrinter.print(receipt) shouldBe expectedReceipt
        }
    }
}

