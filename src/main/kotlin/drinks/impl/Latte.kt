@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import containers.ContainerFactory
import drinks.DrinkType.LATTE
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class Latte : Drink() {
    override val name = LATTE
    override val price = 30
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(LATTE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
    }

    override fun prepareDrink(order: Order) {
        println("Latte prepared ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}