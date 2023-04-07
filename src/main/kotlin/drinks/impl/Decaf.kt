@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.DECAF
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class Decaf : Drink() {
    override val name = DECAF
    override val price = 80
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(DECAF)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepareDrink(order: Order) {
        println("Decaf preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}