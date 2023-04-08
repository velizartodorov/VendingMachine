@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import order.Amount.MEDIUM
import order.Order

class Water : Drink() {
    override val name = "Water"
    override val price = 15

    override fun prepareDrink(order: Order) {
        println("Water prepared ...")
        ContainerFactory.getContainer("water").extractAmount(MEDIUM)
    }
}