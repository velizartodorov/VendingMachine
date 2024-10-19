package drinks.impl

import coin.Coin.FIFTY_CENTS
import order.Amount.NONE
import order.Order
import order.Strength.MAX
import order.Strength.MEDIUM

open class CappuccinoTestHelper {

    fun getCappuccino() = Order.Builder()
        .withDrink("Cappuccino")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getMaxCappuccino() = Order.Builder()
        .withDrink("Cappuccino")
        .withMilk(NONE)
        .withStrength(MAX)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

}