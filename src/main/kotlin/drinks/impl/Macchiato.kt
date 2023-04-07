@file:Suppress("unused")

package drinks.impl

import containers.ContainerFactory
import drinks.DrinkType.MACCHIATO
import order.Amount.*
import order.Order

class Macchiato : Drink() {
    override val name = MACCHIATO
    override val price = 70

    override fun prepareDrink(order: Order) {
        println("Macchiato prepared ...")
        ContainerFactory.getContainer("beans").extractAmount(getAmount(order.strength))
        ContainerFactory.getContainer("milk").extractAmount(order.milk)
        ContainerFactory.getContainer("sugar").extractAmount(order.sugar)
        ContainerFactory.getContainer("water").extractAmount(getAmount(order.drink))
    }
}