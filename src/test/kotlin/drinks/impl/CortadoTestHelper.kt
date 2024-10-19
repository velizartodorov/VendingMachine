package drinks.impl

import coin.Coin.FIFTY_CENTS
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

open class CortadoTestHelper {

    fun getCortado() = Order.Builder()
        .withDrink("Cortado")
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()
}