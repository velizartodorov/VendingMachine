@file:Suppress("unused")

package drinks.impl

import containers.Container.Companion.getContainer
import drinks.impl.Amount.*
import order.Order

class Cappuccino : Drink() {
    override val name = "Cappuccino"
    override val price = 20

    override fun prepareDrink(order: Order) {
        println("Cappuccino preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}