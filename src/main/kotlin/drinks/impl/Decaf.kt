@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import drinks.DrinkType.DECAF
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Decaf : Drink() {
    override val name = DECAF
    override fun price() = 80
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(DECAF)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepare() {
        println("Decaf preparing ...")
    }
}