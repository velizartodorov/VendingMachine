package drinks.impl

import coin.Coin.FIFTY_CENTS
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class CortadoTestHelper {

    fun getCortado(): Order {
        return Order(
            drink = "Cortado",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(FIFTY_CENTS)
        )
    }
}