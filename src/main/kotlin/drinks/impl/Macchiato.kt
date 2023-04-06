@file:Suppress("unused")

package drinks.impl

import coin.Coin.ONE_EURO
import containers.ContainerFactory
import drinks.DrinkType.MACCHIATO
import order.Amount
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

class Macchiato : Drink() {
    override val name = MACCHIATO
    override val price = 70
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(MACCHIATO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(ONE_EURO)
            .build()
    }

    override fun prepare() {
        println("Macchiato prepared ...")
        ContainerFactory.run {
            getContainer("beans").extractAmount(NONE)
            getContainer("milk").extractAmount(Amount.LOW)
            getContainer("sugar").extractAmount(Amount.MEDIUM)
            getContainer("water").extractAmount(Amount.MAX)
        }
    }
}