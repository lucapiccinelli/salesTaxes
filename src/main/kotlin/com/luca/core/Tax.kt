package com.luca.core

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

data class Tax(private val percentage: Double){
    fun chargeForAmount(amount: BigDecimal): BigDecimal {
        val rawPercentageApplication = amount.multiply(BigDecimal.valueOf(percentage))
        return FiveCentsRounder.round(rawPercentageApplication)
    }

    operator fun plus(tax: Tax): Tax = Tax(percentage + tax.percentage)

    companion object{
        fun notCharged() = Tax(0.0)
    }

}

