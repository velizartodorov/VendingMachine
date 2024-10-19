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
                Pick strength (1-4):
    """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val inputStrength = readln().toInt()
        try {
            val selectedStrength = Strength.get(inputStrength)
            println("Strength selected: $selectedStrength")
            order.strength(selectedStrength)
        } catch (e: IllegalArgumentException) {
            reprocess(e, order)
        }
        return order
    }

}