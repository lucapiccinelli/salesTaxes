package com.luca.core

class Sale(private val saleLines: Collection<SaleLine>) {
    companion object{
        fun from(vararg saleLines: SaleLine) = Sale(saleLines.toList())
    }

    fun receipt(): Receipt = saleLines
        .map { saleLine -> ReceiptLine(saleLine) }
        .let { receiptLines -> Receipt(receiptLines) }
}

