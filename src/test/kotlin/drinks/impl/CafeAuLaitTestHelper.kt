package drinks.impl

import coin.Coin.FIFTY_CENTS
import coin.Coin.TWO_EUROS
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class CafeAuLaitTestHelper {

    fun getCafeAuLait(): Order {
        return Order(
            drink = "CafeAuLait",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(TWO_EUROS, FIFTY_CENTS)
        )
    }

}