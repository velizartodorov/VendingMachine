package drinks.impl

import coin.Coin.FIFTY_CENTS
import order.Amount.NONE
import order.Order
import order.Strength.*

open class LatteTestHelper {

    fun getLatte(): Order {
        return Order(
            drink = "Latte",
            milk = NONE,
            strength = MEDIUM,
            sugar = NONE,
            coins = listOf(FIFTY_CENTS)
        )
    }

    fun getSoftLatte(): Order {
        return Order(
            drink = "Latte",
            milk = NONE,
            strength = LOW,
            sugar = NONE,
            coins = listOf(FIFTY_CENTS)
        )
    }

    fun getStrongLatte(): Order {
        return Order(
            drink = "Latte",
            milk = NONE,
            strength = HIGH,
            sugar = NONE,
            coins = listOf(FIFTY_CENTS)
        )
    }

}