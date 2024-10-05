@file:Suppress("unused")

package drinks.impl

import Container.Companion.getContainer
import order.Order

class IcedCoffee : Drink() {
    override val name = "IcedCoffee"
    override val price = 100

    override fun prepareDrink(order: Order) {
        println("Iced Coffee preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}