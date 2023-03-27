@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.LATTE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Latte : Drink() {
    override fun name() = LATTE
    override fun price() = 30
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(LATTE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
    }

    override fun prepare() {
        println("Latte prepared ...")
    }
}