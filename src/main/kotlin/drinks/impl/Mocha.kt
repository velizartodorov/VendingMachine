@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.MOCHA
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Mocha : Drink() {
    override val name = MOCHA
    override val price = 60
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(MOCHA)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepare() {
        println("Mocha prepared ..")
        ContainerFactory.getContainer("beans").extract()
        ContainerFactory.getContainer("milk").extract()
        ContainerFactory.getContainer("sugar").extract()
        ContainerFactory.getContainer("water").extract()
    }
}