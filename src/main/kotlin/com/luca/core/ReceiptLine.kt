package com.luca.core

data class ReceiptLine(private val saleLine: SaleLine) {
    val itemDescription = saleLine.item.itemDescription
    val quantity = saleLine.quantity
    val taxCharge: Money = tax()
    val taxedPrice: Money = applyTaxAndMultiplyByQuantity()

    private fun applyTaxAndMultiplyByQuantity(): Money = (saleLine.item.shelfPrice + taxCharge) * quantity

    private fun tax(): Money = saleLine.item.shelfPrice * saleLine.item.taxPercentage
}