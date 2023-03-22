@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.ESPRESSO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Espresso : Drink() {
    override fun name() = ESPRESSO
    override fun price() = 25
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(ESPRESSO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(listOf(FIFTY_CENTS))
            .build()
    }
}