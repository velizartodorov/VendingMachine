package vending_machine

import coin.Coin.FIFTY_CENTS
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType
import drinks.DrinkType.AMERICANO
import drinks.DrinkType.LATTE
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

object TestHelper {

    fun getAmericano(): Order {
        val sixtyCents = listOf(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS)
        return Order.Builder()
            .drink(AMERICANO)
            .withMilk(NONE)
            .withStrength(MEDIUM)
            .withSugar(NONE)
            .withCoins(sixtyCents)
            .build()
    }

    fun getLatte() = Order.Builder()
        .drink(LATTE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(listOf(FIFTY_CENTS))
        .build()

    fun getCappuccino() = Order.Builder()
        .drink(DrinkType.CAPPUCCINO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(listOf(FIFTY_CENTS))
        .build()

    fun getNonExistingDrink() = Order.Builder()
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(listOf(FIFTY_CENTS))
        .build()
}