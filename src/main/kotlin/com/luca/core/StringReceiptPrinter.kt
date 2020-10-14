package com.luca.core

class StringReceiptPrinter {

    companion object{
        fun print(receipt: Receipt): String = receipt.receiptLines
            .fold(""){ acc, receiptLine -> accumulateLine(acc, receiptLine) }
            .let { printTotal(receipt, it) }

        private fun printTotal(receipt: Receipt, printedLines: String) = """
        $printedLines
        Sales Taxes: ${receipt.totalTaxes}
        Total: ${receipt.saleTotal}
        """.trimIndent()

        private fun accumulateLine(acc: String, receiptLine: ReceiptLine): String = """$acc
        ${printLine(receiptLine)}
        """.trimIndent()

        private fun printLine(receiptLine: ReceiptLine) =
            """${receiptLine.quantity} ${receiptLine.itemDescription}: ${receiptLine.taxedPrice}"""
    }

}
