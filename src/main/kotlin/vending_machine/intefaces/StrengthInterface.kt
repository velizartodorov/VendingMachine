package vending_machine.intefaces

import order.Order
import order.Strength
import order.Strength.*

object StrengthInterface : UserInterface {

    override fun print() {
        println(
            """
    Strength LOW: 1
    Strength MEDIUM: 2
    Strength HIGH: 3
    Strength MAX: 4
    
    ===================================
    PICK A STRENGTH (1 - 4):
    """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val value = readLine()!!.toInt()
        val strength = getStrengthBy(value)
        println("Strength selected: $strength")
        order.strength = strength;
        return order
    }

    private fun getStrengthBy(number: Int?): Strength {
        return when (number) {
            1 -> LOW
            2 -> MEDIUM
            3 -> HIGH
            4 -> MAX
            else -> throw IllegalArgumentException("Strength unsupported: $number")
        }
    }
}