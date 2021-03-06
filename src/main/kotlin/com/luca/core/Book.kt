package com.luca.core

data class Book(val title: String, override val shelfPrice: Money): SaleItem {
    override val itemDescription: String = "book"
    override val taxPercentage: Tax = Tax.notCharged()
}