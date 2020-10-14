package com.luca.core

data class Food(val description: String, override val shelfPrice: Money): SaleItem {
    override val itemDescription: String = description.toLowerCase()
}