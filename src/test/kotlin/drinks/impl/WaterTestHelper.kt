package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount
import order.Amount.NONE
import order.Order

open class WaterTestHelper {

    fun getWater(): Order {
        return Order(
            drink = "Water",
            milk = NONE,
            water = Amount.MEDIUM,
            sugar = null,
            strength = null,
            coins = listOf(ONE_EURO)
        )
    }
}