@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import drinks.DrinkType.ICED_COFFEE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class IcedCoffee : Drink() {
    override fun name() = ICED_COFFEE
    override fun price() = 100
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(ICED_COFFEE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepare() {
        println("Iced Coffee preparing ...")
    }
}