package drinks.impl

import coin.Coin.FIFTY_CENTS
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MAX
import order.Strength.MEDIUM

open class CappuccinoTestHelper {

    fun getCappuccino(): Order {
        return Order(
            drink = "Cappuccino",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MEDIUM,
            coins = listOf(FIFTY_CENTS)
        )
    }

    fun getMaxCappuccino(): Order {
        return Order(
            drink = "Cappuccino",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = NONE,
            strength = MAX,
            coins = listOf(FIFTY_CENTS)
        )
    }

}