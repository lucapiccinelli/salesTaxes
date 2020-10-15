package com.luca.core

class Receipt(val receiptLines: List<ReceiptLine>) {
    val totalTaxes = sumByMoney{ it.taxCharge }

    val saleTotal = sumByMoney{ it.taxedPrice }

    private fun sumByMoney(moneyField: (ReceiptLine) -> Money) =
        receiptLines.fold(Money(0)) { acc, receiptLine -> acc + moneyField(receiptLine) }

    override fun toString(): String = StringReceiptPrinter.print(this)
}
