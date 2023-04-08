@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import order.Amount.*
import order.Order

class Decaf : Drink() {
    override val name = "Decaf"
    override val price = 80

    override fun prepareDrink(order: Order) {
        println("Decaf preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}