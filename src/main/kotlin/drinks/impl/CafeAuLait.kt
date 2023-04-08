@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import order.Amount.*
import order.Order

class CafeAuLait : Drink() {
    override val name = "CafeAuLait"
    override val price = 110

    override fun prepareDrink(order: Order) {
        println("Cafe Au Lait preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}