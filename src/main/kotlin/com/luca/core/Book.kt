package com.luca.core

data class Book(val title: String, override val shelfPrice: Money): SaleItem