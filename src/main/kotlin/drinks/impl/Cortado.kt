@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import containers.ContainerFactory
import drinks.DrinkType.CORTADO
import order.Amount
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class Cortado : Drink() {
    override val name = CORTADO
    override val price = 50
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(CORTADO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
    }

    override fun prepare() {
        println("Cortado preparing ...")
        ContainerFactory.run {
            getContainer("beans").extractAmount(NONE)
            getContainer("milk").extractAmount(LOW)
            getContainer("sugar").extractAmount(Amount.MEDIUM)
            getContainer("water").extractAmount(MAX)
        }
    }
}