@file:Suppress("unused")

package drinks.impl

import containers.Container.Companion.getContainer
import order.Order

class Latte : Drink() {
    override val name = "Latte"
    override val price = 30

    override fun prepareDrink(order: Order) {
        println("Latte prepared ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}