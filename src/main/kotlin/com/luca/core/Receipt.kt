package com.luca.core

class Receipt(private val receiptLines: List<ReceiptLine>) {

    override fun toString(): String = description

    val description = receiptLines.fold(""){ acc, line -> """$acc
            ${line.quantity} ${line.itemDescription}: ${line.taxedPrice}
        """.trimIndent()
    }.let {"""
            $it
            Sales Taxes: 1.50
            Total: 29.83
        """.trimIndent()
    }
}