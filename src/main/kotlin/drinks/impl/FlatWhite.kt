@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.FLAT_WHITE
import order.Amount
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class FlatWhite : Drink() {
    override val name = FLAT_WHITE
    override val price = 70
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
        ContainerFactory.run {
            getContainer("beans").extractAmount(NONE)
            getContainer("milk").extractAmount(LOW)
            getContainer("sugar").extractAmount(Amount.MEDIUM)
            getContainer("water").extractAmount(MAX)
        }
    }
}