@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.CAPPUCCINO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Cappuccino : Drink() {
    override fun name() = CAPPUCCINO
    override fun price() = 20
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(CAPPUCCINO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(listOf(FIFTY_CENTS))
            .build()
    }
}