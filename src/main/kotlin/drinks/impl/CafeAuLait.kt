@file:Suppress("unused")

package drinks.impl

import container.Container.Companion.getContainer
import order.Order


class CafeAuLait : Drink {
    override val name = "CafeAuLait"
    override val price = 110

    override fun prepareDrink(order: Order) {
        println("Cafe Au Lait preparing ...")
        getContainer("beans").extractAmount(getAmount(order.strength))
        getContainer("milk").extractAmount(order.milk)
        getContainer("sugar").extractAmount(order.sugar)
        getContainer("water").extractAmount(getAmount(order.drink))
    }
}