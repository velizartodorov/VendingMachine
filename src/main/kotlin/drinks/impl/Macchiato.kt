@file:Suppress("unused")

package drinks.impl

import containers.Container.Companion.getContainer
import order.Amount.*
import order.Order

class Macchiato : Drink() {
    override val name = "Macchiato"
    override val price = 70

    override fun prepareDrink(order: Order) {
        println("Macchiato prepared ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}