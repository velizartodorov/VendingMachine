@file:Suppress("unused")

package drinks.impl

import containers.Container
import order.Amount.*
import order.Order

class CafeAuLait : Drink() {
    override val name = "CafeAuLait"
    override val price = 110

    override fun prepareDrink(order: Order) {
        println("Cafe Au Lait preparing ...")
        Container.getContainer("beans").extractAmount(getAmount(order.strength))
        Container.getContainer("milk").extractAmount(order.milk)
        Container.getContainer("sugar").extractAmount(order.sugar)
        Container.getContainer("water").extractAmount(getAmount(order.drink))
    }
}