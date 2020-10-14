package com.luca.core

data class GenericItem(val description: String, override val shelfPrice: Money): SaleItem {
    override val taxPercentage: Tax = Tax(0.1)
    override val itemDescription: String = description
}