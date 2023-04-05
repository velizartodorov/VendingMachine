@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.IRISH_COFFEE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class IrishCoffee : Drink() {
    override val name = IRISH_COFFEE
    override val price = 90
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(IRISH_COFFEE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepare() {
        println("Irish Coffee preparing ...")
        ContainerFactory.getContainer("beans").extract()
        ContainerFactory.getContainer("milk").extract()
        ContainerFactory.getContainer("sugar").extract()
        ContainerFactory.getContainer("water").extract()
    }
}