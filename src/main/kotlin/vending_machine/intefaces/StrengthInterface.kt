package vending_machine.intefaces

import order.Order
import order.Strength

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
        val value = readln().toInt()
        val strength = Strength.get(value)
        println("Strength selected: $strength")
        order.strength = strength
        return order
    }
}