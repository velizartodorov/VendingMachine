package vending_machine.intefaces

import order.Amount
import order.Order

object MilkInterface : UserInterface {

    override fun print(order: Order) {
        println(
            """
            ==========================================================
                            ███╗   ███╗██╗██╗     ██╗  ██╗
                            ████╗ ████║██║██║     ██║ ██╔╝
                            ██╔████╔██║██║██║     █████╔╝ 
                            ██║╚██╔╝██║██║██║     ██╔═██╗ 
                            ██║ ╚═╝ ██║██║███████╗██║  ██╗
                            ╚═╝     ╚═╝╚═╝╚══════╝╚═╝  ╚═╝
            ==========================================================
                NONE: 1     LOW: 2   MEDIUM: 3   HIGH: 4    MAX: 5
            ==========================================================
            Pick amount (1-5):
    """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val inputAmount = readln().toInt()
        try {
            val milk = Amount.get(inputAmount)
            println("Milk amount selected: $milk")
            order.milk(milk)
        } catch (e: IllegalArgumentException) {
            reprocess(e, order)
        }
        return order
    }

}