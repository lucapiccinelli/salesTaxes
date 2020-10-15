package com.luca.core

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class FiveCentsRounder {
    companion object{
        fun round(value: BigDecimal): BigDecimal {
            val scale = 100.0
            val decimalRoundedToCents = roundToCents(value)
            val unscaledValue = decimalRoundedToCents.toDouble() * scale
            val remainder = (unscaledValue % 5).toInt()

            return if(doNotNeedRounding(remainder))
                value
                else applyRound(remainder, unscaledValue, scale).let { BigDecimal(it) }
        }

        private fun roundToCents(value: BigDecimal) = value.round(MathContext(3, RoundingMode.HALF_UP))

        private fun applyRound(remainder: Int, unscaledValue: Double, scale: Double): Double = ((5 - remainder) + unscaledValue) / scale

        private fun doNotNeedRounding(remainder: Int) = remainder == 0
    }
}