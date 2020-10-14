package com.luca.core

data class MusicCd(val description: String, override val shelfPrice: Money): SaleItem {
    override val taxPercentage: Tax = Tax(0.1)
    override val itemDescription: String = "music CD"
}