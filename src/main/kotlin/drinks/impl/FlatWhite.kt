@file:Suppress("unused")

package drinks.impl

import container.Container.Companion.getContainer
import order.Order

class FlatWhite : Drink {
    override val name = "FlatWhite"
    override val price = 70

    override fun prepareDrink(order: Order) {
        println("Flat White preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}