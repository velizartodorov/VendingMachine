@file:Suppress("unused")

package drinks.impl

import coin.Coin.TWENTY_CENTS
import containers.ContainerFactory
import drinks.DrinkType.TEA
import order.Amount
import order.Amount.*
import order.Order
import order.Strength.MEDIUM

class Tea : Drink() {
    override val name = TEA
    override val price: Int = 15
    override fun testOrder(): Order {
        return Order.Builder()
            .drink(TEA)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(TWENTY_CENTS)
            .build()
    }

    override fun prepare() {
        println("Tea prepared ...")
        ContainerFactory.run {
            getContainer("tea").extractAmount(LOW)
            getContainer("sugar").extractAmount(Amount.MEDIUM)
            getContainer("water").extractAmount(MAX)
        }
    }
}