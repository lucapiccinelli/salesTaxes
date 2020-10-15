package com.luca.core

data class ReceiptLine(private val saleLine: SaleLine) {
    val itemDescription = saleLine.item.itemDescription
    val quantity = saleLine.quantity
    val taxCharge: Money = chargeTaxes()
    val taxedPrice: Money = applyTaxAndMultiplyByQuantity()

    private fun applyTaxAndMultiplyByQuantity(): Money = (saleLine.item.shelfPrice * quantity) + taxCharge

    private fun chargeTaxes(): Money = saleLine.item.shelfPrice * saleLine.item.taxPercentage * quantity
}