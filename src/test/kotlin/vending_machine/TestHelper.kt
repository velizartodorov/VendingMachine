package vending_machine

import coin.Coin.FIFTY_CENTS
import coin.Coin.TWENTY_CENTS
import drinks.DrinkType.*
import order.Amount.NONE
import order.Order
import order.Strength.LOW
import order.Strength.MEDIUM

object TestHelper {

    fun getAmericano() = Order.Builder()
        .drink(AMERICANO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(listOf(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS))
        .build()

    fun getLatte() = Order.Builder()
        .drink(LATTE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(listOf(FIFTY_CENTS))
        .build()

    fun getSoftLatte() = Order.Builder()
        .drink(LATTE)
        .withMilk(NONE)
        .withStrength(LOW)
        .withSugar(NONE)
        .withCoins(listOf(FIFTY_CENTS))
        .build()

    fun getCappuccino() = Order.Builder()
        .drink(CAPPUCCINO)
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