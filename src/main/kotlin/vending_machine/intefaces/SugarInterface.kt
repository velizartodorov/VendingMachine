package vending_machine.intefaces

import order.Amount
import order.Order

object SugarInterface : UserInterface {

    override fun print() {
        println(
            """
==========================================================
        ██████╗██╗   ██╗ ██████╗  █████╗ ██████╗ 
        ██╔════╝██║   ██║██╔════╝ ██╔══██╗██╔══██╗
        ███████╗██║   ██║██║  ███╗███████║██████╔╝
        ╚════██║██║   ██║██║   ██║██╔══██║██╔══██╗
        ███████║╚██████╔╝╚██████╔╝██║  ██║██║  ██║
        ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝
==========================================================
    NONE: 1     LOW: 2   MEDIUM: 3   HIGH: 4    MAX: 5
==========================================================
Pick amount (1-5):
    """.trimIndent()
        )
    }

    override fun process(order: Order.Builder): Order.Builder {
        val inputAmount = readln().toInt()
        try {
            val sugar = Amount.get(inputAmount)
            println("Sugar amount selected: $sugar")
            order.withSugar(sugar)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            this.print()
            this.process(order)
        }
        return order
    }
}