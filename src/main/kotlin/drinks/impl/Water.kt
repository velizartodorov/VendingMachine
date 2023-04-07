@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import drinks.DrinkType.WATER
import order.Amount
import order.Order

class Water : Drink() {
    override val name = WATER
    override val price = 15

    override fun prepareDrink(order: Order) {
        println("Water prepared ...")
        ContainerFactory.getContainer("water").extractAmount(Amount.MEDIUM)
    }
}