@file:Suppress("unused")

package drinks.impl

import coin.Coin.TWO_EUROS
import drinks.DrinkType.WATER
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Water : Drink() {
    override val name = WATER
    override fun price() = 15
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(WATER)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(TWO_EUROS)
            .build()
    }

    override fun prepare() {
        println("Water prepared ...")
    }
}