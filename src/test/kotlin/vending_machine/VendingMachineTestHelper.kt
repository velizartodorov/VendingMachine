package vending_machine

import coin.Coin.FIFTY_CENTS
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class VendingMachineTestHelper {
    fun getNonExistingDrink(): Order {
        return Order(
            drink = null,
            milk = NONE,
            water = NONE,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(FIFTY_CENTS)
        )
    }
}
