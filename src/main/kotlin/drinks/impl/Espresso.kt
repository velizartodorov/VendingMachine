@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import containers.ContainerFactory
import drinks.DrinkType.ESPRESSO
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class Espresso : Drink() {
    override val name = ESPRESSO
    override val price = 25
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(ESPRESSO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
    }

    override fun prepareDrink(order: Order) {
        println("Espresso preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }

}