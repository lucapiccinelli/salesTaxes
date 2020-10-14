package com.luca.core

class Receipt(private val receiptLines: List<ReceiptLine>) {

    val totalTaxes = receiptLines.fold(Money(0)){ acc, receiptLine -> acc + receiptLine.taxCharge }

    val saleTotal = receiptLines.fold(Money(0)) { acc, receiptLine -> acc + receiptLine.taxedPrice }

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

}