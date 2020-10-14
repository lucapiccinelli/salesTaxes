package com.luca.core

data class ReceiptLine(private val saleLine: SaleLine) {
    val itemDescription = saleLine.item.itemDescription
    val quantity = saleLine.quantity
    val taxCharge: Money = tax()
    val taxedPrice: Money = applyTax()

    private fun applyTax(): Money = saleLine.item.shelfPrice + taxCharge

    private fun tax(): Money = saleLine.item.shelfPrice * saleLine.item.taxPercentage
}