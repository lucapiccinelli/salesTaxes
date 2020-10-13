package com.luca.core

import com.luca.core.SaleLine

class Sale(vararg saleLines: SaleLine) {
    fun receipt(): Receipt = Receipt()
}