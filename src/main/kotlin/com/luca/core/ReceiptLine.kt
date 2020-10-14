package com.luca.core

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

data class ReceiptLine(private val saleLine: SaleLine) {
    val itemDescription = saleLine.item.itemDescription
    val quantity = saleLine.quantity
    val taxCharge: Money = tax()
    val taxedPrice: Money = applyTax()

    private fun applyTax(): Money = saleLine.item.shelfPrice + taxCharge

    private fun tax(): Money = saleLine.item.shelfPrice * saleLine.item.taxPercentage
}