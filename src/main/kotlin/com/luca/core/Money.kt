package com.luca.core

import java.math.BigDecimal
import java.text.DecimalFormat

class Money(private val amount: BigDecimal){
    constructor(amount: Double): this(BigDecimal(amount))
    constructor(amount: Int): this(BigDecimal(amount))

    override fun toString(): String = DecimalFormat("#,##0.00").format(amount)

    operator fun plus(money: Money): Money = Money(amount + money.amount)

    operator fun times(taxPercentage: Tax): Money = taxPercentage.chargeForAmount(amount)
}