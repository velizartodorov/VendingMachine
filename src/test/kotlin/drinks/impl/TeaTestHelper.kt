package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class TeaTestHelper {

    fun getTea(): Order {
        return Order(
            drink = "Tea",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(ONE_EURO)
        )
    }
}