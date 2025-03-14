@file:Suppress("unused")

package drinks.impl

import container.Container.Companion.getContainer
import order.Order

class Americano : Drink {
    override val name = "Americano"
    override val price = 50

    override fun prepareDrink(order: Order) {
        println("Americano preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }

}