package com.luca.core

import java.math.BigDecimal

class FiveCentsRounder {
    companion object{
        fun round(value: BigDecimal): BigDecimal {
            val unscaledValue = value.toDouble() * 100
            val remainder = (unscaledValue % 5).toInt()
            if(remainder == 0) return value

            val roundedValue = ((5 - remainder) + unscaledValue) / 100
            return BigDecimal(roundedValue)
        }
    }
}