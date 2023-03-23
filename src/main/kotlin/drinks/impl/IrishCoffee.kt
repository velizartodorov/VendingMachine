@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import drinks.Drink
import drinks.DrinkType.IRISH_COFFEE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class IrishCoffee : Drink() {
    override fun name() = IRISH_COFFEE
    override fun price() = 90
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(IRISH_COFFEE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(listOf(ONE_EURO))
            .build()
    }
}