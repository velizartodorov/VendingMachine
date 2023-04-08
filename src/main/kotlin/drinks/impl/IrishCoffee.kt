@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import order.Amount.*
import order.Order

class IrishCoffee : Drink() {
    override val name = "IrishCoffee"
    override val price = 90

    override fun prepareDrink(order: Order) {
        println("Irish Coffee preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}