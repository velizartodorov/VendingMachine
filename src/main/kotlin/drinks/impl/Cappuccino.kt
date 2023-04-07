@file:Suppress("unused")

package drinks.impl

import coin.Coin.FIFTY_CENTS
import containers.ContainerFactory.getContainer
import drinks.DrinkType.CAPPUCCINO
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class Cappuccino : Drink() {
    override val name = CAPPUCCINO
    override val price = 20
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(CAPPUCCINO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(FIFTY_CENTS)
            .build()
    }

    override fun prepareDrink(order: Order) {
        println("Cappuccino preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}