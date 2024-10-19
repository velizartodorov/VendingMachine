package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount.MEDIUM
import order.Amount.NONE
import order.Order
import order.Strength

open class MochaTestHelper {

    fun getMocha(): Order {
        return Order(
            drink = "Mocha",
            milk = NONE,
            water = MEDIUM,
            sugar = NONE,
            strength = Strength.MEDIUM,
            coins = listOf(ONE_EURO)
        )
    }

}