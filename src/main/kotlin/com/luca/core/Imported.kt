package com.luca.core

class Imported(private val item: SaleItem): SaleItem by item {
    override val taxPercentage: Tax = item.taxPercentage + Tax(0.05)
    override val itemDescription: String = "imported ${item.itemDescription}"
}
