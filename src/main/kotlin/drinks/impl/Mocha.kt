@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.MOCHA
import order.Amount
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
        ContainerFactory.run {
            getContainer("beans").extractAmount(NONE)
            getContainer("milk").extractAmount(Amount.LOW)
            getContainer("sugar").extractAmount(Amount.MEDIUM)
            getContainer("water").extractAmount(Amount.MAX)
        }
    }
}