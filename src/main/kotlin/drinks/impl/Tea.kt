@file:Suppress("unused")

package drinks.impl

import Container.Companion.getContainer
import order.Order

class Tea : Drink {
    override val name = "Tea"
    override val price = 15

    override fun prepareDrink(order: Order) {
        println("Tea prepared ...")
        getContainer("tea").extractAmount(getAmount(order.strength))
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}