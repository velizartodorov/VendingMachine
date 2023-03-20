package vending_machine

import coin.Coin.FIFTY_CENTS
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
        .withCoins(FIFTY_CENTS)
        .build()

    fun getNonExistingDrink() = Order.Builder()
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()
}