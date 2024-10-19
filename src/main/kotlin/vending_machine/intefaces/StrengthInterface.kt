package vending_machine.intefaces

import order.Order
import order.Strength

object StrengthInterface : UserInterface {

    override fun print(order: Order) {
        println(
            """
            =====================================================================
            ███████╗████████╗██████╗ ███████╗███╗   ██╗ ██████╗ ████████╗██╗  ██╗
            ██╔════╝╚══██╔══╝██╔══██╗██╔════╝████╗  ██║██╔════╝ ╚══██╔══╝██║  ██║
            ███████╗   ██║   ██████╔╝█████╗  ██╔██╗ ██║██║  ███╗   ██║   ███████║
            ╚════██║   ██║   ██╔══██╗██╔══╝  ██║╚██╗██║██║   ██║   ██║   ██╔══██║
            ███████║   ██║   ██║  ██║███████╗██║ ╚████║╚██████╔╝   ██║   ██║  ██║
            ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝    ╚═╝   ╚═╝  ╚═╝
            =====================================================================
                   LOW: 1   MEDIUM: 2   HIGH: 3    MAX: 4
            =====================================================================
             """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        try {
            val selectedStrength = Strength.get(input())
            println("Strength selected: $selectedStrength")
            order.strength(selectedStrength)
        } catch (e: IllegalArgumentException) {
            reprocess(e, order)
        }
        return order
    }

    private fun input(): Int {
        val strength: Int
        while (true) {
            print("Pick strength (1-4): ")
            val input = readln()
            if (input.toIntOrNull()?.let { it in 1..4 } == true) {
                strength = input.toInt()
                break
            } else {
                println("Invalid input. Please enter a number between 1 and 4.")
            }
        }
        return strength
    }

}