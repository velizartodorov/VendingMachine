package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class FlatWhiteTestHelper {

    fun getFlatWhite(): Order {
        return Order(
            drink = "FlatWhite",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(ONE_EURO)
        )
    }
}