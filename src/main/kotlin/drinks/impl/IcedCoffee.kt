@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.ICED_COFFEE
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class IcedCoffee : Drink() {
    override val name = ICED_COFFEE
    override val price = 100
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(ICED_COFFEE)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepareDrink(order: Order) {
        println("Iced Coffee preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}