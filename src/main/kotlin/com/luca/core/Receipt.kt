package com.luca.core

class Receipt {
    override fun toString(): String = """
           1 book : 12.49
           1 music CD: 16.49
           1 chocolate bar: 0.85
           Sales Taxes: 1.50
           Total: 29.83 
        """.trimIndent()
}