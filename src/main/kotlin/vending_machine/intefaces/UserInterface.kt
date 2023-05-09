package vending_machine.intefaces

import order.Order

interface UserInterface {
    fun print()
    fun process(order: Order): Order

    companion object {
        fun getAll() = sequenceOf(
            DrinkInterface,
            StrengthInterface,
            MilkInterface,
            SugarInterface,
            CoinsInterface
        )

        fun printLabel() {
            println(
                """
===============================
V E N D I N G     M A C H I N E
===============================
"""
            )
        }
    }
}