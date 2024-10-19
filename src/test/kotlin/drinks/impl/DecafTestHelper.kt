package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class DecafTestHelper {

    fun getDecaf(): Order {
        return Order(
            drink = "Decaf",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(ONE_EURO)
        )
    }

}