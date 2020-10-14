package com.luca.core

import java.math.BigDecimal
import java.text.NumberFormat

class Money(val amount: BigDecimal){
    constructor(amount: Double): this(BigDecimal(amount))

    override fun toString(): String {
        return NumberFormat.getInstance().format(amount)
    }

    operator fun plus(money: Money): Money = Money(amount + money.amount)
}