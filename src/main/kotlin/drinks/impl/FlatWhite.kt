@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import order.Amount.*
import order.Order

class FlatWhite : Drink() {
    override val name = "FlatWhite"
    override val price = 70

    override fun prepareDrink(order: Order) {
        println("Flat White preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}