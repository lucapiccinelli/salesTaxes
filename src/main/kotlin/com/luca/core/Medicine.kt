package com.luca.core

data class Medicine(val description: String, override val shelfPrice: Money): SaleItem {
    override val taxPercentage: Tax = Tax.notCharged()
    override val itemDescription: String = description.toLowerCase()
}
