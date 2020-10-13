package com.luca.core

import java.math.BigDecimal

class Money(val amount: BigDecimal, val currency: CurrencyEnum = CurrencyEnum.EUR){
    constructor(amount: Double, currency: CurrencyEnum = CurrencyEnum.EUR): this(BigDecimal(amount), currency)
}