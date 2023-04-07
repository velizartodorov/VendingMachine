@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.MOCHA
import order.Amount.*
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

    override fun prepareDrink(order: Order) {
        println("Mocha prepared ..")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}