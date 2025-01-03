@file:Suppress("unused")

package drinks.impl

import container.Container.Companion.getContainer
import order.Order

class Cortado : Drink {
    override val name = "Cortado"
    override val price = 50

    override fun prepareDrink(order: Order) {
        println("Cortado preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}