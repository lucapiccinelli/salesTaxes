package com.luca.core

class Receipt(private val receiptLines: List<ReceiptLine>) {

    val totalTaxes = sumByMoney{ it.taxCharge }

    val saleTotal = sumByMoney{ it.taxedPrice }

    override fun toString(): String = receiptLines
        .fold(""){ acc, line ->
            """$acc
            ${line.quantity} ${line.itemDescription}: ${line.taxedPrice}
            """.trimIndent()
    }.let {"""
            $it
            Sales Taxes: $totalTaxes
            Total: $saleTotal
        """.trimIndent()
    }

    private fun sumByMoney(moneyField: (ReceiptLine) -> Money) = receiptLines.fold(Money(0)) { acc, receiptLine -> acc + moneyField(receiptLine) }
}
