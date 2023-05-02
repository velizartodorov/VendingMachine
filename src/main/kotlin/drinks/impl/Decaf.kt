@file:Suppress("unused")

package drinks.impl

import containers.Container.Companion.getContainer
import drinks.impl.Amount.*
import order.Order

class Decaf : Drink() {
    override val name = "Decaf"
    override val price = 80

    override fun prepareDrink(order: Order) {
        println("Decaf preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}