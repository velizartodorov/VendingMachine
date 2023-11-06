package vending_machine.intefaces

import drinks.impl.Drink
import order.Order
import order.OrderResponse

interface UserInterface {
    fun print()
    fun process(order: Order): Order

    companion object {
        private fun getAll() = sequenceOf(
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

        fun prepare(): OrderResponse {
            println("The vending machine is already running")
            val order = Order.Builder().build()
            getAll().forEach { ui ->
                ui.print()
                ui.process(order)
            }
            return Drink.getDrink(order.drink).prepare(order)
        }

    }

}