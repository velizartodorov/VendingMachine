@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.AMERICANO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Americano : Drink() {
    override fun name() = AMERICANO
    override fun price() = 50
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(AMERICANO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
    }
}