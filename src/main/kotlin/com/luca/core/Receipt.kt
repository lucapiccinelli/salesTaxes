package com.luca.core

class Receipt(private val receiptLines: List<ReceiptLine>) {

    val totalTaxes = sumByMoney{ it.taxCharge }

    val saleTotal = sumByMoney{ it.taxedPrice }

    override fun toString(): String = receiptLines
        .fold(""){ acc, line -> accumulateLine(acc, line) }
        .let { printTotal(it) }

    private fun printTotal(it: String) = """
        $it
        Sales Taxes: $totalTaxes
        Total: $saleTotal
        """.trimIndent()

    private fun accumulateLine(acc: String, line: ReceiptLine): String = """$acc
        ${printLine(line)}
        """.trimIndent()

    private fun printLine(line: ReceiptLine) =
        """${line.quantity} ${line.itemDescription}: ${line.taxedPrice}"""

    private fun sumByMoney(moneyField: (ReceiptLine) -> Money) = receiptLines.fold(Money(0)) { acc, receiptLine -> acc + moneyField(receiptLine) }
}
