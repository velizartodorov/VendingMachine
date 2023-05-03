package vending_machine.intefaces

import order.Amount
import order.Order

object MilkInterface : UserInterface {

    override fun print() {
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

    override fun process(order: Order): Order {
        val value = readLine()!!.toInt()
        val milk = Amount.get(value)
        println("Milk amount selected: $milk")
        order.milk = milk
        return order
    }

}