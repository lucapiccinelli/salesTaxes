package com.luca.core

data class Tax(val percentage: Double){

    companion object{
        fun notCharged() = Tax(0.0)
    }

}