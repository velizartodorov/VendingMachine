package vending_machine.intefaces

import order.Order
import order.Strength

object StrengthInterface : UserInterface {

    override fun print() {
        println(

            """
==========================================================
 / ___|  | |_   _ __    ___   _ __     __ _  | |_  | |__  
 \___ \  | __| | '__|  / _ \ | '_ \   / _` | | __| | '_ \ 
  ___) | | |_  | |    |  __/ | | | | | (_| | | |_  | | | |
 |____/   \__| |_|     \___| |_| |_|  \__, |  \__| |_| |_|
                                      |___/               
==========================================================
       LOW: 1   MEDIUM: 2   HIGH: 3    MAX: 4
==========================================================
    Pick strength (1-4):
    """.trimIndent()
        )
    }

    override fun process(order: Order): Order {
        val inputStrength = readln().toInt()
        if (inputStrength in 1..4) {
            val selectedStrength = Strength.get(inputStrength)
            println("Strength selected: $selectedStrength")
            order.strength = selectedStrength
        } else {
            println("Strength unsupported: $inputStrength")
            this.print()
            this.process(order)
        }
        return order
    }
}