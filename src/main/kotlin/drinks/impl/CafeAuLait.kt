@file:Suppress("unused")

package drinks.impl

import coin.Coin.TWO_EUROS
import containers.ContainerFactory
import drinks.DrinkType.CAFE_AU_LAIT
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class CafeAuLait : Drink() {
    override val name = CAFE_AU_LAIT
    override val price = 110
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(CAFE_AU_LAIT)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(TWO_EUROS)
            .build()
    }

    override fun prepare() {
        println("Cafe Au Lait preparing ...")
        ContainerFactory.getContainer("beans").extractAmount(NONE)
        ContainerFactory.getContainer("milk").extractAmount(Amount.LOW)
        ContainerFactory.getContainer("sugar").extractAmount(Amount.MEDIUM)
        ContainerFactory.getContainer("water").extractAmount(Amount.MAX)
    }
}