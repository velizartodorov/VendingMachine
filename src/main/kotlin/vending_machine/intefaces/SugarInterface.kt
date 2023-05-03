package vending_machine.intefaces

import drinks.impl.Amount
import drinks.impl.Amount.*
import order.Order

object SugarInterface : UserInterface {

    override fun print() {
        println(
            """
    Sugar amount NONE: 0
    Sugar amount LOW: 1
    Sugar amount MEDIUM: 2
    Sugar amount HIGH: 3
    Sugar amount HIGH: 4
    Sugar amount MAX: 5
    
    ===================================
    PICK A SUGAR AMOUNT (0 - 5):
    """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val value = readLine()!!.toInt()
        val sugar = getAmountBy(value)
        println("Sugar amount selected: $sugar")
        order.sugar = sugar
        return order
    }

    private fun getAmountBy(number: Int?): Amount {
        return when (number) {
            0 -> NONE
            1 -> LOW
            2 -> MEDIUM
            3 -> HIGH
            4 -> MAX
            else -> throw IllegalArgumentException("Sugar amount unsupported: $number")
        }
    }
}