@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import drinks.DrinkType.FLAT_WHITE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class FlatWhite : Drink() {
    override val name = FLAT_WHITE
    override fun price() = 70
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(FLAT_WHITE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepare() {
        println("Flat White preparing ...")
    }
}