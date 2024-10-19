package drinks.impl

import coin.Coin.ONE_EURO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class MochaTestHelper {

    fun getMocha() = Order.Builder()
        .withDrink("Mocha")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()

}