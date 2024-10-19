package vending_machine.intefaces

import order.Amount
import order.Order

object SugarInterface : UserInterface {

    override fun print(order: Order) {
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
            """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        try {
            val sugar = Amount.get(input())
            println("Sugar amount selected: $sugar")
            order.sugar(sugar)
        } catch (e: IllegalArgumentException) {
            reprocess(e, order)
        }
        return order
    }

    private fun input(): Int {
        val amount: Int
        while (true) {
            print("Pick amount (1-5): ")
            val input = readln()
            if (input.toIntOrNull()?.let { it in 1..5 } == true) {
                amount = input.toInt()
                break
            } else {
                println("Invalid input. Please enter a number between 1 and 5.")
            }
        }
        return amount
    }
}