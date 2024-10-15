@file:Suppress("unused")

package drinks.impl

import Container.Companion.getContainer
import order.Order

class Water : Drink {
    override val name = "Water"
    override val price = 15

    override fun prepareDrink(order: Order) {
        println("Water prepared ...")
        getContainer("water").extractAmount(order.water)
    }
}