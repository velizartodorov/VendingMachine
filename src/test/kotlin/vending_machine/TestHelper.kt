package vending_machine

import coin.Coin.*
import drinks.DrinkType.*
import order.Amount.NONE
import order.Order
import order.Strength.*

object TestHelper {

    fun getAmericano() = Order.Builder()
        .drink(AMERICANO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS, TWENTY_CENTS)
        .build()

    fun getLatte() = Order.Builder()
        .drink(LATTE)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getCafeAuLait() = Order.Builder()
        .drink(CAFE_AU_LAIT)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(TWO_EUROS, FIFTY_CENTS)
        .build()

    fun getCortado() = Order.Builder()
        .drink(CORTADO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getDecaf() = Order.Builder()
        .drink(DECAF)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(ONE_EURO)
        .build()

    fun getSoftLatte() = Order.Builder()
        .drink(LATTE)
        .withMilk(NONE)
        .withStrength(LOW)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getStrongLatte() = Order.Builder()
        .drink(LATTE)
        .withMilk(NONE)
        .withStrength(HIGH)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getCappuccino() = Order.Builder()
        .drink(CAPPUCCINO)
        .withMilk(NONE)
        .withStrength(MEDIUM)
        .withSugar(NONE)
        .withCoins(FIFTY_CENTS)
        .build()

    fun getMaxCappuccino() = Order.Builder()
        .drink(CAPPUCCINO)
        .withMilk(NONE)
        .withStrength(MAX)
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