package com.luca.core

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

data class ReceiptLine(private val saleLine: SaleLine) {
    val itemDescription = saleLine.item.itemDescription
    val quantity = saleLine.quantity
    val taxedPrice: Money = applyTax()

    private fun applyTax() =
        saleLine.item.shelfPrice + tax()

    private fun tax() =
        Money(saleLine.item.shelfPrice.amount.multiply(BigDecimal(saleLine.item.taxPercentage.percentage), MathContext(2, RoundingMode.HALF_UP)))
}