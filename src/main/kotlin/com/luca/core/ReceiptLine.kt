package com.luca.core

data class ReceiptLine(private val saleLine: SaleLine) {
    val itemDescription = saleLine.item.itemDescription
    val quantity = saleLine.quantity
    val taxedPrice: Money = saleLine.item.shelfPrice
}