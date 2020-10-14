package com.luca.core

interface SaleItem {
    val taxPercentage: Tax
    val itemDescription: String
    val shelfPrice: Money
}

