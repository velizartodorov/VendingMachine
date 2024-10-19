package drinks.impl

import coin.Coin.FIFTY_CENTS
import coin.Coin.TWO_EUROS
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class CafeAuLaitTestHelper {

    fun getCafeAuLait() = Order.Builder()
        .withDrink("CafeAuLait")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(TWO_EUROS, FIFTY_CENTS)
        .build()

}