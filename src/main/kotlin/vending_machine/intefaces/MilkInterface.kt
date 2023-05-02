package vending_machine.intefaces

import order.Amount
import order.Amount.*

object MilkInterface {

    fun get(number: Int?): Amount {
        val amount = getAmountBy(number)
        println("Milk amount selected: $amount")
        return amount
    }

    private fun getAmountBy(number: Int?): Amount {
        return when (number) {
            0 -> NONE
            1 -> LOW
            2 -> MEDIUM
            3 -> HIGH
            4 -> MAX
            else -> throw IllegalArgumentException("Milk amount unsupported: $number")
        }
    }

    fun print() {
        println(
            """
    Milk amount NONE: 0
    Milk amount LOW: 1
    Milk amount MEDIUM: 2
    Milk amount HIGH: 3
    Milk amount HIGH: 4
    Milk amount MAX: 5
    
    ===================================
    PICK A MILK AMOUNT (0 - 5):
    """.trimIndent()
        )
    }
}