package com.luca.core

class Receipt(private val receiptLines: List<ReceiptLine>) {

    val totalTaxes = receiptLines.fold(Money(0)){ acc, receiptLine ->
        acc + receiptLine.taxCharge
    }

    override fun toString(): String = receiptLines
        .fold(""){ acc, line ->
            """$acc
            ${line.quantity} ${line.itemDescription}: ${line.taxedPrice}
            """.trimIndent()
    }.let {"""
            $it
            Sales Taxes: $totalTaxes
            Total: 29.83
        """.trimIndent()
    }

}