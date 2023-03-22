package vending_machine

import coin.Coin.*
import drinks.DrinkType
import drinks.DrinkType.AMERICANO
import order.Amount.NONE
import order.Order
import order.Strength.MEDIUM

object DrinkHelper {

    fun getAmericano() = Order.Builder()
        .drink(AMERICANO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(listOf(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS))
        .build()

    fun getLatte() = Order.Builder()
        .drink(DrinkType.LATTE)
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