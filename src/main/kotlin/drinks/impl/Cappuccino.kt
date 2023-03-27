@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import drinks.DrinkType.CAPPUCCINO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Cappuccino : Drink() {
    override val name = CAPPUCCINO
    override fun price() = 20
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(CAPPUCCINO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
    }

    override fun prepare() {
        println("Cappuccino preparing ...")
    }
}