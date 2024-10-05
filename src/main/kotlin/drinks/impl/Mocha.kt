@file:Suppress("unused")

package drinks.impl

import Container.Companion.getContainer
import order.Order

class Mocha : Drink() {
    override val name = "Mocha"
    override val price = 60

    override fun prepareDrink(order: Order) {
        println("Mocha prepared ..")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}