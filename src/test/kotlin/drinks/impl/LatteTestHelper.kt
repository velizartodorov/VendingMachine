package drinks.impl

import coin.Coin.FIFTY_CENTS
import order.Amount.NONE
import order.Order
import order.Strength.*

open class LatteTestHelper {

    fun getLatte() = Order.Builder()
        .withDrink("Latte")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getSoftLatte() = Order.Builder()
        .withDrink("Latte")
        .withMilk(NONE)
        .withStrength(LOW)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getStrongLatte() = Order.Builder()
        .withDrink("Latte")
        .withMilk(NONE)
        .withStrength(HIGH)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

}