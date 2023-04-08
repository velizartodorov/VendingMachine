@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import order.Amount.*
import order.Order

class Tea : Drink() {
    override val name = "Tea"
    override val price = 15

    override fun prepareDrink(order: Order) {
        println("Tea prepared ...")
        ContainerFactory.getContainer("tea").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}