@file:Suppress("unused")

package drinks.impl

import container.Container.Companion.getContainer
import order.Order

class Espresso : Drink {
    override val name = "Espresso"
    override val price = 25

    override fun prepareDrink(order: Order) {
        println("Espresso preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }

}