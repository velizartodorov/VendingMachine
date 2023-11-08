package vending_machine.intefaces

import order.Order
import order.Strength

object StrengthInterface : UserInterface {

    override fun print() {
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

    override fun process(order: Order.Builder): Order.Builder {
        val inputStrength = readln().toInt()
        try {
            val selectedStrength = Strength.get(inputStrength)
            println("Strength selected: $selectedStrength")
            order.withStrength(selectedStrength)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            this.print()
            this.process(order)
        }
        return order
    }

}