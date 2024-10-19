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
            """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        try {
            val milk = Amount.get(input())
            println("Milk amount selected: $milk")
            order.milk(milk)
        } catch (e: IllegalArgumentException) {
            reprocess(e, order)
        }
        return order
    }

    private fun input(): Int {
        val inputDrink: Int
        while (true) {
            print("Pick amount (1-5): ")
            val input = readln()
            if (input.toIntOrNull()?.let { it in 1..5 } == true) {
                inputDrink = input.toInt()
                break
            } else {
                println("Invalid input. Please enter a number between 1 and 5.")
            }
        }
        return inputDrink
    }

}