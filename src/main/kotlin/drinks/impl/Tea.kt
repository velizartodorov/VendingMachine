@file:Suppress("unused")

package drinks.impl

import containers.Container.Companion.getContainer
import drinks.impl.Amount.*
import order.Order

class Tea : Drink() {
    override val name = "Tea"
    override val price = 15

    override fun prepareDrink(order: Order) {
        println("Tea prepared ...")
        getContainer("tea").extractAmount(getAmount(order.strength))
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}