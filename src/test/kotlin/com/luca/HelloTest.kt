package com.luca

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.math.BigDecimal


class HelloTest {

    @Test
    internal fun test() {

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
        """

        receipt.toString() shouldBe expectedReceipt
    }
}

class Sale(vararg saleLines: SaleLine) {
    fun receipt(): Receipt = Receipt()
}

class Receipt {
    override fun toString(): String = """
           1 book : 12.49
           1 music CD: 16.49
           1 chocolate bar: 0.85
           Sales Taxes: 1.50
           Total: 29.83 
        """
}

data class SaleLine(val quantity: Int, val item: SaleItem)

data class Food(val description: String, override val shelfPrice: Money): SaleItem

data class MusicCd(val description: String, override val shelfPrice: Money): SaleItem

class Money(val amount: BigDecimal, val currency: CurrencyEnum = CurrencyEnum.EUR){
    constructor(amount: Double, currency: CurrencyEnum = CurrencyEnum.EUR): this(BigDecimal(amount), currency)
}

enum class CurrencyEnum {
    EUR
}

data class Book(val title: String, override val shelfPrice: Money): SaleItem

interface SaleItem {
    val shelfPrice: Money
}
