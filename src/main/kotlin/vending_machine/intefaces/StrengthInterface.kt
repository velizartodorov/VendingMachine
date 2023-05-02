package vending_machine.intefaces

import order.Strength
import order.Strength.*

object StrengthInterface {

    fun get(number: Int?): Strength {
        val strength = getStrengthBy(number)
        println("Strength selected: $strength")
        return strength
    }

    private fun getStrengthBy(number: Int?): Strength {
        return when (number) {
            1 -> LOW
            2 -> MEDIUM
            3 -> HIGH
            4 -> MAX
            else -> throw IllegalArgumentException("Strength unsupported: $number")
        }
    }

    fun print() {
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
}