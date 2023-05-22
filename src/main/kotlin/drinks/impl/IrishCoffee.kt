@file:Suppress("unused")

package drinks.impl

import containers.Container.Companion.getContainer
import order.Order

class IrishCoffee : Drink() {
    override val name = "IrishCoffee"
    override val price = 90

    override fun prepareDrink(order: Order) {
        println("Irish Coffee preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}