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
    }
}