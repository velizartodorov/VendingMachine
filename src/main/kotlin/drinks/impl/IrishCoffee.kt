@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import drinks.DrinkType.IRISH_COFFEE
import order.Amount.*
import order.Order

class IrishCoffee : Drink() {
    override val name = IRISH_COFFEE
    override val price = 90

    override fun prepareDrink(order: Order) {
        println("Irish Coffee preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}