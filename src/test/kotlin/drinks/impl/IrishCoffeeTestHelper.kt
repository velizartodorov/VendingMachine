package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class IrishCoffeeTestHelper {

    val irishCoffee = Order(
        drink = "IrishCoffee",
        milk = NONE,
        strength = MEDIUM,
        sugar = NONE,
        coins = listOf(ONE_EURO)
    )
}