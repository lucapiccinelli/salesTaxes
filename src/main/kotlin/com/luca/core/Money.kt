package com.luca.core

import java.math.BigDecimal
import java.text.NumberFormat

class Money(val amount: BigDecimal, val currency: CurrencyEnum = CurrencyEnum.EUR){
    constructor(amount: Double, currency: CurrencyEnum = CurrencyEnum.EUR): this(BigDecimal(amount), currency)

    override fun toString(): String {
        return NumberFormat.getInstance().format(amount)
    }
}