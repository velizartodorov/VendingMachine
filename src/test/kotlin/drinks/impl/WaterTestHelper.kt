package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount.NONE
import order.Order

open class WaterTestHelper {

    fun getWater() = Order.Builder()
        .withDrink("Water")
        .withMilk(NONE)
        .withCoins(ONE_EURO)
        .build()
}