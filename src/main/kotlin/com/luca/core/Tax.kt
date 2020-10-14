package com.luca.core

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

data class Tax(private val percentage: Double){
    fun chargeForAmount(amount: BigDecimal): BigDecimal =
        amount.multiply(BigDecimal.valueOf(percentage), MathContext(2, RoundingMode.HALF_UP))

    companion object{
        fun notCharged() = Tax(0.0)
    }

}