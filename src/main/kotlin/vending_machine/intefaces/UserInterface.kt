package vending_machine.intefaces

import order.Order
import java.util.stream.Stream

interface UserInterface {
    fun print()
    fun process(order: Order): Order

    companion object {
        fun getAll(): Stream<UserInterface> {
            return listOf(
                DrinkInterface,
                StrengthInterface,
                MilkInterface,
                SugarInterface,
                CoinsInterface
            ).stream()
        }
    }
}