package com.luca.core

interface SaleItem {
    val tax: Double
    val itemDescription: String
    val shelfPrice: Money
}